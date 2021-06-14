package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.Random;


public class HomePage extends BasePage {

    private MobileElement counterElement;
    private MobileElement IncrementButtonElement;
    private int tapsNumber;

    public HomePage(AppiumDriver driver) {
        super(driver);
        setWaitDelay(3);
        counterElement = finder.byValueKey("counter");
        IncrementButtonElement= finder.byValueKey("increment");
        Random rand = new Random();
        tapsNumber = rand.nextInt(9)+1;
    }

    public boolean clickButton() {
        if (IncrementButtonElement != null) {
            for (int i =tapsNumber; i>0; i--){
                IncrementButtonElement.click();
            }
            return true;
        }
        return false;
    }

    public boolean checkCouterValue() {

        if (counterElement != null && counterElement.getText().equals(""+tapsNumber)) {
            //String treeString = (String) driver.executeScript("flutter: getRenderTree");
            //System.out.println(treeString);
           // String test = counterElement.getText();
            //System.out.println("ESTA imprimiendo");
            //System.out.println(test);

            return true;
        }
        return false;

    }

}