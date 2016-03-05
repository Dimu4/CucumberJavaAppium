package support;


import hooks.TestHooks;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.*;
import pages.ScreenBase;


public class TestBase {

	public static AppiumDriver driver;
	public static ScreenBase scr;

	@BeforeSuite
	public void setUp(){

		System.out.println("Starting Appium driver.....");
		driver = TestHooks.getDriver();

		System.out.println("ScreenBase constructor starting....");
		scr = new ScreenBase();


	}

	@AfterSuite
	public void tearDown(){
		System.out.println(".......Stopping Appium driver");
		driver.quit();
	}
}
