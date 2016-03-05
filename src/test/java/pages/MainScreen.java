package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestBase;

import java.util.concurrent.TimeUnit;

/**
 * Created by abarabash on 2/16/16.
 */
public class MainScreen extends TestBase{

    @AndroidFindBy(name = "Log In")
    @iOSFindBy(name = "login_btn")
    public MobileElement loginButton;

    @AndroidFindBy(id = "username")
    @iOSFindBy(name = "user_name")
    public MobileElement userName;

    @AndroidFindBy(id = "password")
    @iOSFindBy(name = "password")
    public MobileElement password;

    @AndroidFindBy(name = "Failed Login")
    @iOSFindBy(name = "Failed Login")
    public MobileElement failedLogin;

    @AndroidFindBy(name = "signUpButton")
    @iOSFindBy(name = "sign_up_btn")
    public MobileElement signUpButton;

    public MainScreen() {

        System.out.println("Initializing MainScreen elements....");
        PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
    }
}
