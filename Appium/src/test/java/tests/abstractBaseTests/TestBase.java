package tests.abstractBaseTests;

import cucumber.api.testng.AbstractTestNGCucumberTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */
public abstract class TestBase extends AbstractTestNGCucumberTests {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    protected static AndroidDriver<MobileElement> driver;

    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
    public abstract String getName();

    /**
     * Method to initialize the test's page
     */
    @BeforeTest
    public abstract void setUpPage() throws InterruptedException;

    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Required capabilities for local execution
        capabilities.setCapability("retryBackoffTime", "500");
        capabilities.setCapability("maxRetryCount", "20");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "R58M43XDFDW");
        capabilities.setCapability("platformVersion", "10");
        //TODO modify with the full APK path
        capabilities.setCapability("app","C:/FutterAutomationTest/Application/app-debug.apk");
        capabilities.setCapability("automationName","Flutter");


        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, "true");
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, "true");


        driver = new AndroidDriver<MobileElement>(url, capabilities);
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);


    }

    @AfterSuite
    public void tearDownAppium() {
        driver.quit();
    }

}