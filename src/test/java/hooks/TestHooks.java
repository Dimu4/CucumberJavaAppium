package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import support.TestBase;

public class TestHooks extends TestBase{
    @Before
    public void startDirver(Scenario scenario) throws Exception {
        System.out.println("Starting Appium driver.....");
    }

    @After
    public void stoptDirver(Scenario scenario) throws Exception {
        System.out.println("Stopping Appium driver.....");
        driver.resetApp();
    }
}
