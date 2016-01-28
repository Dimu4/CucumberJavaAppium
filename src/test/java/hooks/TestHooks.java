package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import support.TestBase;
import utils.CommonUtils;

public class
TestHooks extends TestBase{
    @Before
    public void startDirver(Scenario scenario) throws Exception {
        if (driver == null) {
            CommonUtils.loadIOSConfigProp(loadPropertyFile);
            CommonUtils.setIOSCapabilities();
            driver = CommonUtils.getIOSDriver();
        }
    }

    @After
    public void stoptDirver(Scenario scenario) throws Exception {
        System.out.println("Stopping Appium driver.....");
        driver.resetApp();
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}
