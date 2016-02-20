package pagesiOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestBase;

/**
 * Created by abarabash on 2/20/16.
 */
public class UserListScreen extends TestBase {

   public WebElement userList(){
       return driver.findElement(By.name("user_list"));
   }




}
