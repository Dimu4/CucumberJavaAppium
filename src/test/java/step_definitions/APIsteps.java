package step_definitions;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import support.TestBase;
import utils.ApiClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static step_definitions.LoginSignupSteps.*;
import static utils.ApiHelper.getJsonFromFile;

/**
 * Created by abarabash on 2/19/16.
 */
public class APIsteps extends TestBase{

    public static final String baseServiceUrl = "api.parse.com/1/";

    ApiClient client = new ApiClient();

    String jsonFilePath = "/json/";
    String COOKIES = "";


    String userID = "";


    public void postJson(String jsonFileName, String apiName) throws IOException {

        //client = new ApiClient();

        JsonObject jsonEntity = getJsonFromFile(jsonFilePath + jsonFileName);
        HttpEntity requestEntity = new StringEntity(jsonEntity.toString());

        client.setHost(baseServiceUrl);
        client.setSchema("https");
        client.setAPI(apiName);
        client.buildURI();
        client.setMethod("post");
        client.setJsonEntity(requestEntity);
        client.addHeader("X-Parse-Application-Id", "xDVmXYblOTb3TCYEcKVLqFgediqIBjvE6ugKUqMW");
        client.addHeader("X-Parse-REST-API-Key", "h3V1eLz3sEqzH0IPvsJZDna4yMjEuDPUCdA94jca");
        client.setRequestToPost();
        client.execute(COOKIES);
    }

    public void callApiwParams(String method, String api, List<NameValuePair> params){
        client = new ApiClient();
        client.setHost(baseServiceUrl);
        client.setSchema("https");
        client.setAPI(api);
        client.setParams(params);
        client.buildURIwParam();
        client.setMethod(method);
        client.setRequest();
        client.addHeaderToGet("X-Parse-Application-Id", "xDVmXYblOTb3TCYEcKVLqFgediqIBjvE6ugKUqMW");
        client.addHeaderToGet("X-Parse-REST-API-Key", "h3V1eLz3sEqzH0IPvsJZDna4yMjEuDPUCdA94jca");
        client.execute(COOKIES);
    }


    public void callApi(String method, String api) {
        client = new ApiClient();
        client.setHost(baseServiceUrl);
        client.setSchema("https");
        client.setAPI(api);

        client.buildURI();
        client.setMethod(method);
        client.setRequest();
        client.addHeaderToGet("X-Parse-Application-Id", "xDVmXYblOTb3TCYEcKVLqFgediqIBjvE6ugKUqMW");
        client.addHeaderToGet("X-Parse-REST-API-Key", "h3V1eLz3sEqzH0IPvsJZDna4yMjEuDPUCdA94jca");
        client.execute(COOKIES);
    }


    @Given("^create a user using API request with \"([^\"]*)\"$")
    public void creatingAUserUsingAPIRequestWith(String fileName) throws Throwable {

        postJson(fileName, "users");

        String response = client.getHttpResponse().toString();
    }

    @Then("^login to Instagram app as new user$")
    public static void loginToInstagramAppAsNewUser() throws Throwable {

        iTapOnLoginButton();
        iTypeIntoUsernameField("userFromJson");
        iTypeIntoPasswordField("userpassword");
        iTapOnLoginButton();
    }

    @Then("^saving userId$")
    public void savingUserId()  {
        JsonObject response = client.getJsonResponse();
        System.out.println(response.toString());
        userID = response.get("objectId").getAsString();
    }

    @Then("^make a get request to obtain posts$")
    public void makeAGetRequestToObtainPosts()  {
        String api = "classes/Post";
        List<NameValuePair> entityParams = new ArrayList<NameValuePair>();
        entityParams.add(new BasicNameValuePair("where", "{\"userId\":\"" + userID + "\"}"));

        callApiwParams("get", api, entityParams);
        JsonObject result = client.getJsonResponse();

    }

    @Then("^verify that image is posted$")
    public void verifyThatImageIsPostedViaAPIRequest() {
        JsonObject result = client.getJsonResponse();
        JsonArray resultsJson = result.get("results").getAsJsonArray();  //getAsJsonArray().get(0).getAsJsonObject().get("imageFile").toString();
        assertNotNull(resultsJson);

    }

    @Then("^delete user via API request$")
    public void deleteUserViaAPIRequest() throws IOException {

        String sessionToken = getSessionToken();

        deleteUser(sessionToken, userID);

        String result = client.getJsonResponse().toString();

        assertTrue(result.equals("{}"), "delete user ERROR");
    }

    private void deleteUser(String sessionToken, String userID) {
        client = new ApiClient();
        client.setHost(baseServiceUrl);
        client.setSchema("https");
        client.setAPI("users/" + userID);
        client.buildURI();
        client.setMethod("delete");
        client.setRequest();
        client.addHeaderToGet("X-Parse-Application-Id", "xDVmXYblOTb3TCYEcKVLqFgediqIBjvE6ugKUqMW");
        client.addHeaderToGet("X-Parse-REST-API-Key", "h3V1eLz3sEqzH0IPvsJZDna4yMjEuDPUCdA94jca");
        client.addHeaderToGet("X-Parse-Session-Token", sessionToken);
        client.execute(COOKIES);
    }

    public String getSessionToken() throws IOException {
        String jsonFileName = "user.json";
        JsonObject user = getJsonFromFile(jsonFilePath + jsonFileName);
        String username = user.get("username").getAsString();
        String password = user.get("password").getAsString();

        String api = "login";
        List<NameValuePair> entityParams = new ArrayList<NameValuePair>();
        entityParams.add(new BasicNameValuePair("username", username));
        entityParams.add(new BasicNameValuePair("password", password));

        callApiwParams("get", api, entityParams);

        return client.getJsonResponse().get("sessionToken").getAsString();
    }


}
