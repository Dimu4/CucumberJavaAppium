package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.TestBase;
import utils.CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class
TestHooks extends TestBase{


    @Before
    public void startDriver(Scenario scenario) throws Exception {
        if (driver == null) {
            CommonUtils.setIOSCapabilities();
            driver = CommonUtils.getIOSDriver();
        }
    }

    @After
    public void stopDriver(Scenario scenario) {
        try{
//            TODO: create new dir screenshots/
//            TODO: get scenario name from scenario property and name screeshot based on that using regex
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File testScreenShot = new File(System.getProperty("user.dir") + "/target/screenshot.jpg");
            FileUtils.copyFile(scrFile, testScreenShot);

//            converting file to array of  bytes
//            TODO: move to separate method
            byte[] b = new byte[(int) scrFile.length()];
            try {
                FileInputStream fileInputStream = new FileInputStream(scrFile);
                fileInputStream.read(b);
                for (int i = 0; i < b.length; i++) System.out.print((char) b[i]);

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found.");
                e.printStackTrace();
            }
            catch (IOException e1) {
                System.out.println("Error Reading The File.");
                e1.printStackTrace();
            }

            scenario.embed(b, "image/png");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        finally {
            driver.resetApp();
        }
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}
