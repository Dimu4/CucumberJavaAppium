package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainScreen;
import pages.UserListScreen;
import support.TestBase;

import java.util.Map;

import static org.testng.Assert.assertTrue;

/**
 * Created by idorovskikh on 1/9/16.
 */
public class LoginSignupSteps extends TestBase {

    public MainScreen mainScreen = new MainScreen();
    public UserListScreen userList = new UserListScreen();

    @When("^I tap on Login button$")
    public void iTapOnLoginButton() {
        mainScreen.loginButton().click();
    }

    @Then("^I type \"([^\"]*)\" into username field$")
    public void iTypeIntoUsernameField(String name) {
        mainScreen.userName().sendKeys(name);
    }

    @And("^I type \"([^\"]*)\" into password field$")
    public void iTypeIntoPasswordField(String password) {
        mainScreen.password().sendKeys(password);
    }

    @And("^I verify user is logged in$")
    public void iVerifyUserIsLoggedIn() {
        assertTrue(userList.list().isDisplayed());
    }

    @And("^I verify that login is failed$")
    public void iVerifyThatUserLoginisFailed() {
        assertTrue(mainScreen.failedLogin().isDisplayed());
    }

    @Then("^I tap on Signup button$")
    public void iTapOnSignupButton() {
        mainScreen.signUpButton().click();
    }

    @And("^I verify that I singed up$")
    public void iVerifyThatISingedUp() {
        assertTrue(userList.list().isDisplayed());
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
