package support;



import hooks.TestHooks;
import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.CommonUtils;

import java.io.IOException;

public class TestBase {


	public static AppiumDriver driver;
	public static String loadPropertyFile = "iOS.properties";

    @BeforeSuite
	public void setUp() throws IOException, InterruptedException{
		System.out.println("Starting Appium driver.....");
		driver = TestHooks.getDriver();
	}


//  @AfterSuite
//	public void tearDown() throws IOException{
//
//		driver.quit();
//
//
//	}

}
