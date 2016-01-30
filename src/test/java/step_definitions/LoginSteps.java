package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import support.TestBase;

/**
 * Created by idorovskikh on 1/9/16.
 */
public class LoginSteps extends TestBase {

    @When("^I tap on Login button$")
    public void i_tap_on_Login_button(){
        driver.findElement(By.name("login_btn")).click();
    }

    @Then("^I type \"(.*?)\" into username field$")
    public void i_type_into_username_field(String arg1){

    }

    @Then("^I type \"(.*?)\" into password field$")
    public void i_type_into_password_field(String arg1){

    }


    @Then("^I verify user is logged in$")
    public void i_verify_user_is_logged_in(){
    }


}
