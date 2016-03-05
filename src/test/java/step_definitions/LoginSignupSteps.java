package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.TestBase;

import java.util.Map;

import static org.testng.Assert.assertTrue;

/**
 * Created by idorovskikh on 1/9/16.
 */
public class LoginSignupSteps extends TestBase {

    @When("^I tap on Login button$")
    public static void iTapOnLoginButton() {

        scr.mainScreen.loginButton.click();
    }

    @Then("^I type \"([^\"]*)\" into username field$")
    public static void iTypeIntoUsernameField(String name) {
        scr.mainScreen.userName.sendKeys(name);
    }

    @And("^I type \"([^\"]*)\" into password field$")
    public static void iTypeIntoPasswordField(String password) {
        scr.mainScreen.password.sendKeys(password);
    }

    @And("^I verify user is logged in$")
    public void iVerifyUserIsLoggedIn() {
        assertTrue(scr.userListScreen.list.isDisplayed());
    }

    @And("^I verify that login is failed$")
    public void iVerifyThatUserLoginisFailed() {
        assertTrue(scr.mainScreen.failedLogin.isDisplayed());
    }

    @Then("^I tap on Signup button$")
    public void iTapOnSignupButton() {
        scr.mainScreen.signUpButton.click();
    }

    @And("^I verify that I singed up$")
    public void iVerifyThatISingedUp() {
        assertTrue(scr.userListScreen.list.isDisplayed());
    }

    @Given("^I login to Instagram app with credentials:$")
    public void iLoginToInstagramAppWithCredentials(DataTable datatable) {

        Map<String, String> credentials = datatable.asMap(String.class, String.class);

        iTapOnLoginButton();
        iTypeIntoUsernameField(credentials.get("Username"));
        iTypeIntoPasswordField(credentials.get("Password"));
        iTapOnLoginButton();
    }


}
