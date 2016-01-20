package support;



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
		if (driver == null) {
			CommonUtils.loadIOSConfigProp(loadPropertyFile);
			CommonUtils.setIOSCapabilities();
			driver = CommonUtils.getIOSDriver();
		}
	}

//  @AfterSuite
//	public void tearDown() throws IOException{
//
//		driver.quit();
//
//
//	}

}
