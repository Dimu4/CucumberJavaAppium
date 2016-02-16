package step_definitions;

import cucumber.api.java.en.Given;
import pages.ScreenBase;
import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class FollowSteps extends TestBase{

    ScreenBase scr = new ScreenBase();

    @Given("^I tap on username \"([^\"]*)\"$")
    public void iTapOnUsername(String username)  {
        scr.userListScreen.user(username).click();

    }
}
