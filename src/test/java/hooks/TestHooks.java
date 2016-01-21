package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks {
    @Before
    public void startDirver(Scenario scenario) throws Exception {
        System.out.println("Starting Appium driver.....");
    }

    @After
    public void stoptDirver(Scenario scenario) throws Exception {
        System.out.println("Stopping Appium driver.....");
    }
}
