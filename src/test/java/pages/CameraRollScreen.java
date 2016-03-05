package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class CameraRollScreen extends TestBase {

    public WebElement cell(int cellNumber) {
        return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + cellNumber + "]"));
    }
}
