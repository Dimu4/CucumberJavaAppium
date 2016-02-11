package step_definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

import static org.testng.Assert.assertTrue;


/**
 * Created by abarabash on 2/10/16.
 */
public class FollowSteps extends TestBase{
    @Then("^I make a swipe down gesture$")
    public void swipeDownGesture() {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int startx = width /4;
        int starty = height / 5;
        int endx = width / 4;
        int endy = height;
        int duration = 500;
        driver.swipe(startx, starty, endx, endy, duration);
    }

    @Then("^I wait \"([^\"]*)\" sec$")
    public void iWaitSec(Integer arg0) throws Throwable {
        Thread.sleep(arg0 * 1000);
    }



    @Then("^I verify that \"([^\"]*)\" is presented$")
    public void iVerifyThatIsPresented(String arg0) {
        try {
            WebElement element = driver.findElement(By.name("cell_1_following"));
            assertTrue(element.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
