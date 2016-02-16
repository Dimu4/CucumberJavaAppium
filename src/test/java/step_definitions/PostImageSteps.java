package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ScreenBase;
import support.TestBase;

import static org.testng.Assert.assertTrue;

/**
 * Created by abarabash on 2/13/16.
 */

public class PostImageSteps extends TestBase {

    ScreenBase scr = new ScreenBase();


    @And("^I verify post image screen$")
    public void iVerifyPostImageScreen() throws Throwable {

        assertTrue(scr.postImageScreen.view().isDisplayed());
    }

    @Then("^I select (\\d+)st image from Gallery$")
    public void iSelectStImageFromGallery(int number)  {
        scr.cameraRollScreen.cell(number).click();
    }

    @Then("^I tap on post button$")
    public void iTapOnPostButton() throws Throwable {
        scr.userListScreen.postButton().click();
    }

    @Then("^I tap on choose_image button$")
    public void iTapOnChoose_imageButton() throws Throwable {
       scr.postImageScreen.chooseImageButton().click();
    }

    @And("^I tap on Camera Roll button$")
    public void iTapOnCameraRollButton() throws Throwable {
        scr.photos.cameraRoll().click();
    }

    @And("^I tap on post_image button$")
    public void iTapOnPost_imageButton() {
        scr.postImageScreen.postImageButton().click();
    }

    @And("^I tap on OK button$")
    public void iTapOnOKButton() throws Throwable {
        scr.postImageScreen.okButton().click();
    }
}
