package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestBase;

import static org.testng.Assert.assertTrue;

/**
 * Created by abarabash on 2/13/16.
 */
public class FollowSteps extends TestBase{
    @Then("^I make a swipe down gesture$")
    public void iMakeASwipeDownGesture()  {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startx = width / 2;
        int starty = height / 5;
        int endx = width / 2;
        int endy = height;
        int duration = 500;

        driver.swipe(startx, starty, endx, endy, duration);
    }

    @Then("^I wait for \"([^\"]*)\" element$")
    public void iWaitForElement(String arg0) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(arg0)));
    }

    @Then("^I verify that \"([^\"]*)\" is presented$")
    public void iVerifyThatIsPresented(String arg0) throws Throwable {
       WebElement element = driver.findElement(By.name(arg0));
       Boolean result = element.isDisplayed();

        Assert.assertTrue(result);
    }

    @Given("^I tap on cell_(\\d+) button$")
    public void iTapOnCell_Button(int arg0)  {
        scr.userListScreen.cell_1().click();
    }

    @Then("^I wait for cell_(\\d+)_following element$")
    public void iWaitForCell__followingElement(int arg0)  {

        WebElement cell1 = scr.userListScreen.cell1Following();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By) cell1));
    }

    @Then("^I verify that cellfollowing is presented$")
    public void iVerifyThatCellFollowingIsPresented(int arg0)  {
        assertTrue(scr.userListScreen.cell1Following().isDisplayed());
    }
}
