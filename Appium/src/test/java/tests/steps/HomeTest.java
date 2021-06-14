package tests.steps;


import pages.HomePage;
import tests.abstractBaseTests.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.testng.asserts.SoftAssert;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "classpath:features/homeTest",
        plugin = {"pretty"}
)
public class HomeTest extends TestBase {

    private HomePage homePage;
    private SoftAssert soft;

    @Override
    public String getName() {
        return "Home Page";
    }

    @Given("^User is on the home page$")
    public void setUpPage() {
        homePage = new HomePage(driver);
        soft = new SoftAssert();
    }

    @When("^The user clicks multiple times the button$")
    public void inputNameFieldIsInTheHomeScreen() {

        soft.assertTrue(homePage.clickButton(), "Click the floating button");
    }

    @Then("^The counter shows the number of clicks$")
    public void inputEmailFieldIsInTheHomeScreen() {
        soft.assertTrue(homePage.checkCouterValue(), "Correct count of clicks");
    }

}