package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import support.TestBase;
import utils.CommonUtils;

import java.io.File;

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
        File scrFile = null;

        driver.resetApp();
    }



    public static AppiumDriver getDriver(){
        return driver;
    }
}
