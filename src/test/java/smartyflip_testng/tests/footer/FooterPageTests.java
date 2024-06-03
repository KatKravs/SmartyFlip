package smartyflip_testng.tests.footer;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;
import smartyflip_testng.pages.footer.FooterPage;
import smartyflip_testng.tests.TestBase;


public class FooterPageTests extends TestBase {
    BasePage basePage;
    FooterPage footerPage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        footerPage = new FooterPage(app.driver);
        basePage.goToPage(HomePage.homePageURL());
//        basePage.isCurrentPage(HomePage.homePageURL(), true);

    }

    @Test
    public void smallSmartyFlipIconIsPresent() {
        Assert.assertTrue(footerPage.getSmallSmartyFlipIcon().isDisplayed(), "SmallSmartyFlipIcon is present");
    }

    @Test
    public void smartyFlipGmailCom() {
        Assert.assertTrue(footerPage.getSmartyFlipGmailCom().isDisplayed(), "SmartyFlipGmailCom is present");
    }

    @Test
    public void textHereCould() {
        Assert.assertTrue(footerPage.getTextHereCouldBeYourAdvertisement().isDisplayed(), "HighVoltageDevelopers is present");
    }

    @Test
    public void checkBrokenLinkTest() {
        basePage.checkBrokenLinks();
    }


}