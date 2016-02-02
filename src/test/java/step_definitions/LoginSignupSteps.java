package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import support.TestBase;

/**
 * Created by idorovskikh on 1/9/16.
 */
public class LoginSignupSteps extends TestBase {

    @Given("^I login to Instagram app$")
    public void iLoginToInstagramApp(){
        driver.findElement(By.name("login_btn")).click();
        driver.findElement(By.name("user_name")).sendKeys("igor");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("login_btn")).click();
        Boolean isLogged = driver.findElement(By.name("user_list")).isEnabled();
        Assert.assertTrue(isLogged);
    }

    @When("^I tap on Login button$")
    public void iTapOnLoginButton(){
        driver.findElement(By.name("login_btn")).click();
    }

    @Then("^I type \"([^\"]*)\" into username field$")
    public void iTypeIntoUsernameField(String userName){
        driver.findElement(By.name("user_name")).sendKeys(userName);
    }

    @And("^I type \"([^\"]*)\" into password field$")
    public void iTypeIntoPasswordField(String password){
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^I verify user is logged in$")
    public void iVerifyUserIsLoggedIn(){
        System.out.println("User has been successfully logged in ");
        Boolean isLogged = driver.findElement(By.name("user_list")).isEnabled();
        Assert.assertTrue(isLogged);
    }

    @Then("^I tap on Signup button$")
    public void iTapOnSignupButton(){
        driver.findElement(By.name("sign_up_btn")).click();
    }

    @And("^I verified \"([^\"]*)\" message$")
    public void iVerifyThatNewUserHasBeenCreated(String error){
        Boolean isUserExists = driver.findElement(By.name(error)).isDisplayed();
        Assert.assertTrue(isUserExists);
        driver.findElement(By.name("OK")).click();
    }
}
