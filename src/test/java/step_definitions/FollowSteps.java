package step_definitions;

import cucumber.api.java.en.Given;
import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class FollowSteps extends TestBase{

    @Given("^I tap on username \"([^\"]*)\"$")
    public void iTapOnUsername(String username)  {
        scr.userListScreen.user(username).click();

    }
}
