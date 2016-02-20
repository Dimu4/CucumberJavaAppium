package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

import static org.junit.Assert.assertTrue;


/**
 * Created by abarabash on 9/29/15.
 */

@SuppressWarnings("ALL")
public class APIClient {

    public static String HOST;
    public static String API;
    public static String COOKIES;
    public static String formCOOKIES;
    public static CloseableHttpClient httpClient;
    public static JsonObject jsonCreateCarResponse;
    public static URI URI;
    public static String strUrl;
    public static BasicCookieStore cookieStore;

    public static HttpGet getRequest;
    public static HttpPost postRequest = new HttpPost();
    public static String method;
    public static String entity;
    public static CloseableHttpResponse httpResponse;
    public static StatusLine statusLine;
    public static JsonObject jsonResponse;
    public static HttpUriRequest request;
    JsonParser parser = new JsonParser();
    public static List<NameValuePair> entityParams = new ArrayList<NameValuePair>();
    public static String schema;


    public APIClient() {
        setHttpClient();
    }

    public void setHttpClient() {
        try {
            httpClient = HttpClients.custom().
                    setHostnameVerifier(new AllowAllHostnameVerifier()).
                    setSslcontext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                            return true;
                        }
                    }).build()).build();
        } catch (Exception E) {
        }
    }

    public void setHost(String host) {
        HOST = host;
    }

    public void setSchema(String arg1) {

        schema = arg1;
    }

    public void setAPI(String api) {

        API = api;
    }

    public void setParams(List<NameValuePair> params) {
        entityParams = params;
    }

    public void buildURIwParam() {

        try {
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme(schema);
            uriBuilder.setHost(HOST);
            uriBuilder.setPath(API);
            uriBuilder.setParameters(entityParams);

            URI = uriBuilder.build();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public void buildURI() {

        try {
            URI = new URIBuilder()
                    .setScheme(schema)
                    .setHost(HOST)
                    .setPath(API)
                    .build();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public void setCOOKIES(String cookies) {
        COOKIES = cookies;
    }

    public String getCOOKIES() {
        return COOKIES;
    }

    public void saveCOOKIES() {
        String MINFO = "minfo=";
        String USER = "user=";
        String ACCT_TYPE = "accttype=";

        Map<String, String> cookies = new HashMap<String, String>();

        Header[] headersFromResponse = httpResponse.getHeaders("Set-Cookie");

        for (Header header : headersFromResponse) {
            String headerValue = header.getValue();
            String tokens[] = headerValue.split(";");

            for (String s : tokens) {
                if (true || s.contains(MINFO) || s.contains(USER) || s.contains(ACCT_TYPE)) {
                    String[] nameValue = s.split("=");
                    if (nameValue != null && nameValue.length == 2)    //look for the name and value pair and update
                    // only if the cookie has a value
                    {
                        cookies.put(nameValue[0], nameValue[1]);
                    }
                }

            }

        }

        COOKIES = getStringFromMapCookies(cookies);

    }

    public static String getStringFromMapCookies(Map сookies) {
        StringBuilder sb = new StringBuilder();
        Iterator itr = сookies.entrySet().iterator();

        Iterator<Map.Entry<Integer, String>> iterator = сookies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            sb.append(String.format("%s=%s; ", entry.getKey(), entry.getValue()));

        }

        String cookie = sb.toString();

        return cookie;
    }

    public String getFormCOOKIES() {
        formCOOKIES = "";


        for (String each : COOKIES.split(";")) {
            formCOOKIES += each + "\n";
        }

        return formCOOKIES;
    }

    public void clearCookies() {
        COOKIES = "";
    }


    public void setJsonEntity(HttpEntity requestEntity) {
        postRequest = new HttpPost(URI);
        postRequest.setEntity(requestEntity);
        postRequest.addHeader("Content-Type", "application/json");
    }

    public void addHeader(String name, String value){
        postRequest.addHeader(name, value);
    }

    public void setXMLEntity(String stringEntity) {

        postRequest = new HttpPost(URI);
        try {
            postRequest.setEntity(new StringEntity(stringEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }

        postRequest.addHeader("Content-Type", "text/plain");
    }

    public void setEntity(List<NameValuePair> entityParams) {
        postRequest = new HttpPost(URI);
        try {
            postRequest.setEntity(new UrlEncodedFormEntity(entityParams));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void setRequestToPost() {
        request = postRequest;
    }


    public void setRequest(){

        if (method.equals("get")) {

            request = new HttpGet(URI);

        }
        if (method.equals("post")) {

            request = new HttpPost(URI);
        }

        if (method.equals("delete")) {
            request = new HttpDelete(URI);
        }
    }

    public void setMethod(String arg1) {
        method = arg1;
    }

    public void execute(String COOKIES) {

        cookieStore = CookieUtil.createCookieStore(URI.toString(), COOKIES);
        HttpContext localContext = new BasicHttpContext();
        localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);


        try {

            httpResponse = httpClient.execute(request, localContext);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void executeRequest() {

        try {

            httpResponse = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public CloseableHttpResponse getHttpResponse() {
        return httpResponse;
    }


    public String getStrEntity() {

        try {
            entity = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ParseException e) {
            // e.printStackTrace();
        }

        return entity;
    }

    public StatusLine getStatusLine() {
        statusLine = httpResponse.getStatusLine();
        return statusLine;
    }

    public void parseEntity() {
        jsonResponse = parser.parse(entity).getAsJsonObject();
    }

    public JsonObject getJsonResponse() {
        getStrEntity();
        parseEntity();
        return jsonResponse;
    }


    public void closeClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkIfSuccess() {

        try {
            assertTrue(jsonResponse.get("code").toString().contains("success"));

        } catch (AssertionError e) {

            getFormCOOKIES();

            throw new AssertionError(jsonResponse.get("messages").toString());

        }
    }


    public void addHeaderToGet(String key, String value) {
        request.setHeader(key, value);
    }
}
