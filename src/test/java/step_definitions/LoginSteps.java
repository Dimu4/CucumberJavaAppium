package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by idorovskikh on 1/9/16.
 */
public class LoginSteps {

    @When("^I tap on Login button$")
    public void iTapOnLoginButton(){
        System.out.println("Login button is tapped");
    }

    @Then("^I type \"([^\"]*)\" into username field$")
    public void iTypeIntoUsernameField(String userName){
        System.out.println("username " + userName + " has been entered");
    }

    @And("^I type \"([^\"]*)\" into password field$")
    public void iTypeIntoPasswordField(String password){
        System.out.println("username " + password + " has been entered");
    }

    @And("^I verify user is logged in$")
    public void iVerifyUserIsLoggedIn(){
        System.out.println("User has been successfully logged in ");
    }

    @Then("^I tap on Signup button$")
    public void iTapOnSignupButton(){
        System.out.println("Signup button is tapped");
    }

    @And("^I verify that new user has been created$")
    public void iVerifyThatNewUserHasBeenCreated(){
        System.out.println("New user has been created!");
    }
}
