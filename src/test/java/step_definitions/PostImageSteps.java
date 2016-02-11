package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import support.TestBase;

/**
 * Created by idorovskikh on 2/2/16.
 */
public class PostImageSteps extends TestBase{

    @Then("^I tap on \"([^\"]*)\" button$")
    public void iTapOnButton(String btn){
        driver.findElement(By.name(btn)).click();
    }

    @And("^I verify post image screen$")
    public void iVerifyPostImageScreen(){
        Boolean isLogged = driver.findElement(By.name("post_image_view")).isEnabled();
        Assert.assertTrue(isLogged);
    }

    @Then("^I select (\\d+)st image from Gallery$")
    public void iSelectStImageFromGallery(int index){
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")).click();
    }
}
