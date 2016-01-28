package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by idorovskikh on 1/18/16.
 */
public class CommonUtils {
    private static Properties prop = new Properties();
    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String BUNDLE_ID;
    public static String BASE_PKG;
    public static String APP_ACTIVITY;
    public static String APP_PASSWORD;
    private static String APPIUM_PORT;
    public static String AUTOMATION_INSTRUMENTATION;
    public static String PLATFORM_NAME;
    public static Integer NEW_COMMAND_TIMEOUT;
    public static String PLATFORM_VERSION;
    public static String DEVICE_READY_TIMEOUT;
    public static String DEVICE_NAME;
    public static String APP;
    public static String BROWSER_NAME;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static URL serverUrl;
    private static AppiumDriver driver;

    public static void loadIOSConfigProp(String propertyFileName) throws IOException
    {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
        prop.load(file);

        EXPLICIT_WAIT_TIME = Integer
                .parseInt(prop.getProperty("explicit.wait"));
        IMPLICIT_WAIT_TIME = Integer
                .parseInt(prop.getProperty("implicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
        APP = System.getProperty("user.dir") + prop.getProperty("application.path");
        BUNDLE_ID = prop.getProperty("application.app");
        APPIUM_PORT = prop.getProperty("appium.server.port");
        AUTOMATION_INSTRUMENTATION=prop.getProperty("automation.instumentation");
        DEVICE_NAME=prop.getProperty("device.name");
        BROWSER_NAME=prop.getProperty("browser.name");
        PLATFORM_NAME=prop.getProperty("platform.name");
        PLATFORM_VERSION=prop.getProperty("platform.version");
        NEW_COMMAND_TIMEOUT  = Integer.valueOf(prop.getProperty("new.command.timeout"));
        DEVICE_READY_TIMEOUT=prop.getProperty("device.ready.timeout");
    }


    public static void setIOSCapabilities() {
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
//                CommonUtils.BROWSER_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                CommonUtils.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
                CommonUtils.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                CommonUtils.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                CommonUtils.AUTOMATION_INSTRUMENTATION);
        capabilities.setCapability(MobileCapabilityType.APP, CommonUtils.BUNDLE_ID);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
                CommonUtils.NEW_COMMAND_TIMEOUT);
        capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT,
                CommonUtils.DEVICE_READY_TIMEOUT);
        capabilities.setCapability(MobileCapabilityType.APP,
                CommonUtils.APP);

    }

    public static AppiumDriver getIOSDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        driver = new IOSDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
