package smartyflip_cucumber.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import smartyflip_testng.pages.HomePage;
import smartyflip_testng.pages.donate.DonatePage;
import smartyflip_testng.tests.TestBase;

import static smartyflip_testng.pages.ApplicationManager.app;

public class DonatePageSteps {
    WebDriver driver = app.getDriver();
    DonatePage donatePage = new DonatePage(driver);
    HomePage homePage = new HomePage(driver);


    @Given("User open HOME_PAGE")
    public void user_launches_the_browser() {
        if (TestBase.HEADLESS_MODE) {
            app.initHeadless();
        } else {
            app.init();
        }
    }

    @When("User clicks DONATE_LINK")
    public void clicks_DonatePage_link() {
        homePage.clickOnDonateLink();
    }

    @When("User verifies DONATE_PAGE")
    public void user_verifies_DONATE_PAGE() {
        Assert.assertTrue(donatePage.isDonatePageTitleDisplayed());
    }

    @And("User close the browser")
    public void userCloseBrowser() {
        app.stop();
    }
}
