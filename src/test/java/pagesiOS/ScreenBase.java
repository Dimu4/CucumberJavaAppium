package pagesiOS;

import support.TestBase;

/**
 * Created by abarabash on 2/20/16.
 */
public class ScreenBase extends TestBase {

   public MainScreen mainScreen;
    public UserListScreen userListScreen;

    public ScreenBase(){
        mainScreen = new MainScreen();
        userListScreen = new UserListScreen();
    }


}
