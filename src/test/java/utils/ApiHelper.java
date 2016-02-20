package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abarabash on 2/19/16.
 */
public class ApiHelper {

    List<NameValuePair> entityParams;

    public static JsonObject getJsonFromFile(String fileRelativePath) throws IOException {
        String fileContents = "";
        String file = fileRelativePath;


        BufferedReader br = new BufferedReader(new InputStreamReader(new DefaultResourceLoader().getResource(file).getInputStream()));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line.trim());
                sb.append("\n");
                line = br.readLine();
            }
            fileContents = sb.toString();
        } finally {
            br.close();
        }

        JsonObject expectedJsonResponse = new JsonParser().parse(fileContents).getAsJsonObject();

        return expectedJsonResponse;
    }

    public void setParams(){
        String paramName1 = "X-Parse-Application-Id";
        String paramValue1 = "xDVmXYblOTb3TCYEcKVLqFgediqIBjvE6ugKUqMW";
        String paramName2 = "X-Parse-REST-API-Key";
        String paramValue2 = "h3V1eLz3sEqzH0IPvsJZDna4yMjEuDPUCdA94jca";

        entityParams = new ArrayList<NameValuePair>();
        entityParams.add(new BasicNameValuePair(paramName1, paramValue1));
        entityParams.add(new BasicNameValuePair(paramName2, paramValue2));

    }

    public static String getStringFromFile(String file) {

        String fileContents = "";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new DefaultResourceLoader().getResource(file).getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line.trim());
                sb.append("\n");
                line = br.readLine();
            }
            fileContents = sb.toString();
        }
        catch (IOException e) { e.printStackTrace();}
        finally {
            try{
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileContents;
    }
}
