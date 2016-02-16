package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class PostImageScreen extends TestBase {

    public WebElement view() {
        return driver.findElement(By.name("post_image_view"));
    }

    public WebElement chooseImageButton() {
        return driver.findElement(By.name("choose_image"));
    }

    public WebElement postImageButton() {
        return driver.findElement(By.name("post_image"));
    }

    public WebElement okButton() {
        return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]"));
    }
}
