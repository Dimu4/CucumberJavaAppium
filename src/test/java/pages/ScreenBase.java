package pages;

import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class ScreenBase extends TestBase {


    public MainScreen mainScreen;
    public UserListScreen userListScreen;


    public ScreenBase(){

        System.out.println("ScreenBase constructor executing...");
    }

    public void initialize(){

        mainScreen = new MainScreen();
        userListScreen = new UserListScreen();

    }

}
