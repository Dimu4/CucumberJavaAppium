package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

import java.util.Map;

/**
 * Created by idorovskikh on 1/9/16.
 */
public class LoginSignupSteps extends TestBase {

    @Given("^I login to Instagram app$")
    public void iLoginToInstagramApp(){

    }

    @When("^I tap on Login button$")
    public void iTapOnLoginButton(){
        scr.mainScreen.loginButton().click();
    }


    @Then("^I type \"([^\"]*)\" into username field$")
    public void iTypeIntoUsernameField(String name)  {
        scr.mainScreen.userName().sendKeys(name);

    }

    @And("^I type \"([^\"]*)\" into password field$")
    public void iTypeIntoPasswordField(String password)  {
        scr.mainScreen.password().sendKeys(password);
    }

    @And("^I verify user is logged in$")
    public void iVerifyUserIsLoggedIn()  {
       Boolean result = scr.userListScreen.userList().isDisplayed();
       Assert.assertTrue(result);
    }

    @And("^I verify that login is failed$")
    public void iVerifyThatUserLoginisFailed(){
        Boolean result = scr.mainScreen.loginAlert().isDisplayed();
        Assert.assertTrue(result);
    }

    @Then("^I tap on Signup button$")
    public void iTapOnSignupButton()  {
        scr.mainScreen.signUpButton().click();
    }

    @And("^I verify that I singed up$")
    public void iVerifyThatISingedUp()  {
       Boolean result = driver.findElement(By.name("User List")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Given("^I login to Instagram app with credentials:$")
    public void iLoginToInstagramAppWithCredentials(DataTable datatable)  {

        Map<String, String> credentials = datatable.asMap(String.class, String.class);
        String password = credentials.get("Password");
        String username = credentials.get("Username");

        iTapOnLoginButton();
        iTypeIntoUsernameField(username);
        iTypeIntoPasswordField(password);
        iTapOnLoginButton();
    }

    @Then("^I tap on \"([^\"]*)\" button$")
    public void iTapOnButton(String elementName)  {
       WebElement button = driver.findElement(By.name(elementName));
        button.click();
    }
}
