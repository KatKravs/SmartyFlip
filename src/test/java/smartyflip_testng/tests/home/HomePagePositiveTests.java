package smartyflip_testng.tests.home;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;
import smartyflip_testng.tests.TestBase;

public class HomePagePositiveTests extends TestBase {

    private HomePage homePage;
    private BasePage basePage;

    @BeforeMethod
    public void precondition(){
        basePage = new BasePage(app.driver);
        homePage = new HomePage(app.driver);
        basePage.goToPage(HomePage.homePageURL());
//        basePage.isCurrentPage(HomePage.homePageURL(),true);
    }

    @Test
    public void checkBrokenImagesTest(){
        basePage.checkBrokenImages();
    }

    @Test
    public void verifyHomePageTitleDescriptionDisplayedTest() {
        Assert.assertTrue(homePage.isHomePageTitleDescriptionDisplayed(), "Home page title description is not displayed");
    }
    @Test
    public void verifyHomePageLogoTitleDisplayedTest() {
        Assert.assertTrue(homePage.isHomePageLogoTitleDisplayed(), "Home page logo title is not displayed");
    }

    @Test
    public void verifyHomePageInvitationTextDisplayedTest(){
        Assert.assertTrue(homePage.isHomePageInvitationTextDisplayed(),"Invitation text is not displayed on the home page.");
    }

}
