package step_definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void iVerifyThatIsPresented(String elementName) {
        try {
            WebElement element = driver.findElement(By.name(elementName));
            assertTrue(element.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I wait for \"([^\"]*)\" element$")
    public void iWaitForElement(String arg0) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(arg0)));

    }
}
