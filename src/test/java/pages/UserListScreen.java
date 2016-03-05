package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import support.TestBase;

import java.util.concurrent.TimeUnit;

/**
 * Created by abarabash on 2/16/16.
 */
public class UserListScreen extends TestBase {

    @AndroidFindBy(id = "userList")
    @iOSFindBy(name = "user_list")
    public MobileElement list;

    @AndroidFindBy(id = "share")
    @iOSFindBy(name = "Post")
    public MobileElement postButton;

    public UserListScreen() {

        System.out.println("Initializing UserListScreen elements....");
        PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
    }

    public WebElement user(String username) {
       return driver.findElement(By.name(username));
    }
}
