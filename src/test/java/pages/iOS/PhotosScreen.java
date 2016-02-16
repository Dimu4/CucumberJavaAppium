package pages.iOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class PhotosScreen extends TestBase {

    public WebElement cameraRoll() {
        return driver.findElement(By.name("Camera Roll"));
    }
}
