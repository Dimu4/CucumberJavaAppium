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

    public WebElement userListText() {
        return driver.findElement(By.name("User List"));
    }

    public WebElement cell_1() {
        return driver.findElement(By.name("cell_1"));
    }

    public WebElement cell1Following() {
        return driver.findElement(By.name("cell_1_following"));
    }
}
