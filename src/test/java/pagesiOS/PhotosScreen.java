package pagesiOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by abarabash on 2/16/16.
 */
public class PhotosScreen extends ScreenBase {

    public WebElement cameraRoll() {
        return driver.findElement(By.name("Camera Roll"));
    }
}
