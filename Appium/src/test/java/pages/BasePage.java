package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pro.truongsinh.appium_flutter.FlutterFinder;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public abstract class BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;
    private int delay;
    /**
     * The driver
     */
    protected final AppiumDriver driver;
    protected FlutterFinder finder;

    /**
     * A base constructor that sets the page's driver
     *
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     *
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    protected BasePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new  AppiumFieldDecorator(driver, 3, TimeUnit.SECONDS), this);
        finder = new FlutterFinder(driver);
    }

    public void setWaitDelay(int delay){
        this.delay = delay;
    }

}