package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class UserListScreen extends TestBase {

    public WebElement list() {
        return driver.findElement(By.name("user_list"));
    }

    public WebElement postButton() {
        return driver.findElement(By.name("Post"));
    }

    public WebElement user(String username) {
       return driver.findElement(By.name(username));
    }
}
