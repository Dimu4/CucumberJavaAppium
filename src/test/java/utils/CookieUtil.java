package utils;

import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by abarabash on 9/30/15.
 */

public abstract class CookieUtil {

    private static final String MINFO = "minfo=";
    private static final String USER = "user=";
    private static final String ACCT_TYPE = "accttype=";
    private static final String COOKIE_HEADER = "Set-Cookie";


    // in same format as http request cookie header
    public static String getCookies(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();

        for (Cookie c : request.getCookies()) {
            sb.append(String.format("%s=%s;", c.getName(), c.getValue()));
        }

        String cookie = sb.toString();

        return cookie;
    }

    public static String getCookiesFromResponse(HttpServletRequest request, HttpServletResponse response) {
        if (response == null)
            return "";

        //retain the cookies from the original request
        //then update only the once returned from platform identity
        Map<String, String> expediacookies = getCookiesFromRequest(request);

        //get the "Set-Cookie" header value from the response
        Collection headers = new ArrayList();
        headers = response.getHeaders(COOKIE_HEADER);
        Iterator itr = headers.iterator();

        while (itr.hasNext()) {
            String str = (String) itr.next();
            String tokens[] = str.split(";");

            for (String s : tokens) {
                if (s.contains(MINFO) || s.contains(USER) || s.contains(ACCT_TYPE)) {
                    String[] nameValue = s.split("=");
                    if (nameValue != null && nameValue.length == 2)    //look for the name and value pair and update
                    // only if the cookie has a value
                    {
                        expediacookies.put(nameValue[0], nameValue[1]);
                    }
                }

            }
        }

        return getCookies(expediacookies);
    }

    private static String getCookies(Map expediaCookies) {
        StringBuilder sb = new StringBuilder();
        Iterator itr = expediaCookies.entrySet().iterator();


        Iterator<Map.Entry<Integer, String>> iterator = expediaCookies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            sb.append(String.format("%s=%s;", entry.getKey(), entry.getValue()));

        }

        String cookie = sb.toString();

        return cookie;
    }

    private static Map<String, String> getCookiesFromRequest(HttpServletRequest request) {
        Map<String, String> requestcookies = new HashMap<String, String>();
        for (Cookie c : request.getCookies()) {
            requestcookies.put(c.getName(), c.getValue());

        }

        return requestcookies;
    }

    public static BasicCookieStore createCookieStore(String targetURL, String cookieString) {
        BasicCookieStore cookieStore = new BasicCookieStore();

        String cookieDomain = getCookieDomain(targetURL);

        if (StringUtils.isNotBlank(cookieString)) {

            String[] cookies = cookieString.split(";");
            for (String cookieStr : cookies) {
                String[] cookieNameValuePair = cookieStr.split("=");

                // Skip cookies that have no value
                if (cookieNameValuePair.length < 2) continue;

                String cookieName;
                cookieName = StringUtils.trim(cookieNameValuePair[0]);
                String cookieValue = StringUtils.trim(cookieNameValuePair[1]);
                BasicClientCookie cookie = new BasicClientCookie(cookieName, cookieValue);
                cookie.setDomain(cookieDomain);
                cookie.setPath("/");
                cookieStore.addCookie(cookie);
            }
        }

        return cookieStore;
    }

    private static String getCookieDomain(String targetURL) {
        try {
            URL domain = new URL(targetURL);
            return String.format(".%s", domain.getHost());
        } catch (MalformedURLException e) {
            return ".";
        }
    }

}
