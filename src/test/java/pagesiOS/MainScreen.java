package pagesiOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * Created by abarabash on 2/20/16.
 */
public class MainScreen extends TestBase{

    public WebElement loginButton(){
        return driver.findElement(By.name("login_btn"));
    }

    public WebElement userName(){
        return driver.findElement(By.name("user_name"));
    }

    public WebElement password(){
        return driver.findElement(By.name("password"));
    }

    public WebElement signUpButton(){
        return driver.findElement(By.name("sign_up_btn"));
    }

    public WebElement loginAlert(){
        return driver.findElement(By.name("Failed Login"));
    }

}
