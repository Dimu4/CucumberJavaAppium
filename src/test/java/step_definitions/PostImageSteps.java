package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * **Created by abarabash on 2/13/16.
 */
public class PostImageSteps extends TestBase {
    @And("^I verify post image screen$")
    public void iVerifyPostImageScreen() throws Throwable {
       Boolean result = driver.findElement(By.name("post_image_view")).isDisplayed();

        Assert.assertTrue(result);
    }

    @Then("^I select (\\d+)st image from Gallery$")
    public void iSelectStImageFromGallery(int cellNumber)  {

       WebElement icon = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + cellNumber + "]"));
        icon.click();

    }
}
