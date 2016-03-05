package pages;

import support.TestBase;

/**
 * Created by abarabash on 2/16/16.
 */
public class ScreenBase extends TestBase {

    public CameraRollScreen cameraRollScreen;
    public PostImageScreen postImageScreen;
    public MainScreen mainScreen;
    public UserListScreen userListScreen;
    public PhotosScreen photos;

    public ScreenBase(){

    }

    public void initialize(){
        cameraRollScreen = new CameraRollScreen();
        postImageScreen = new PostImageScreen();
        mainScreen = new MainScreen();
        userListScreen = new UserListScreen();
        photos = new PhotosScreen();
    }

}
