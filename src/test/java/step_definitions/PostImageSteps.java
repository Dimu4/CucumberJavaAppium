package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import support.TestBase;

import static org.testng.Assert.assertTrue;
import static step_definitions.Common.iTapOnButton;

/**
 * Created by abarabash on 2/13/16.
 */

public class PostImageSteps extends TestBase {

    @And("^I verify post image screen$")
    public void iVerifyPostImageScreen() {
        assertTrue(scr.postImageScreen.view().isDisplayed());
    }

    @Then("^I select (\\d+)st image from Gallery$")
    public void iSelectStImageFromGallery(int number) {
        scr.cameraRollScreen.cell(number).click();
    }

    @Then("^I tap on post button$")
    public void iTapOnPostButton()  {
        scr.userListScreen.postButton().click();
    }

    @Then("^I tap on choose_image button$")
    public void iTapOnChoose_imageButton()  {
        scr.postImageScreen.chooseImageButton().click();
    }

    @And("^I tap on Camera Roll button$")
    public void iTapOnCameraRollButton()  {
        scr.photos.cameraRoll().click();
    }

    @And("^I tap on post_image button$")
    public void iTapOnPost_imageButton() {
        scr.postImageScreen.postImageButton().click();
    }

    @And("^I tap on OK button$")
    public void iTapOnOKButton()  {
        scr.postImageScreen.okButton().click();
    }

    @Then("^post image via UI$")
    public void postImage()  {
        iTapOnPostButton();
        iTapOnChoose_imageButton();
        iTapOnButton("OK");
        iTapOnCameraRollButton();
        iSelectStImageFromGallery(1);
        iTapOnPost_imageButton();
        iTapOnOKButton();
    }


}
