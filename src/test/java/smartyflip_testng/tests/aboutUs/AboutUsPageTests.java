package smartyflip_testng.tests.aboutUs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.aboutUs.AboutUsPage;
import smartyflip_testng.tests.TestBase;


public class AboutUsPageTests extends TestBase {
    private AboutUsPage aboutUsPage;
    private BasePage basePage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        aboutUsPage = new AboutUsPage(app.driver);
        basePage.goToPage(AboutUsPage.aboutUsPageURL());
        basePage.isCurrentPage(AboutUsPage.aboutUsPageURL(), true);
    }

    @Test
    public void aboutUsHeaderIsPresent() {
        Assert.assertTrue(aboutUsPage.getAboutUsHeader().isDisplayed(), "AboutUs in header is present");
    }

    @Test
    public void smartyFlipSmallIconIsPresent() {
        Assert.assertTrue(aboutUsPage.getSmartyFlipSmallIcon().isDisplayed(), "SmartyFlipSmallIcon is present");
    }

    @Test
    public void smartyFlipBigIconIsPresent() {
        Assert.assertTrue(aboutUsPage.getSmartyFlipBigIcon().isDisplayed(), "SmartyFlipBigIcon is present");
    }

    @Test
    public void aboutUsContentIsPresent() {
        Assert.assertTrue(aboutUsPage.getAboutUsContent().isDisplayed(), "AboutUsContent is present");
    }

    @Test
    public void questionCardsIsPresent() {
        Assert.assertTrue(aboutUsPage.getQuestionCards().isDisplayed(), "QuestionCard is present");
    }

    @Test
    public void customModulesIsPresent() {
        Assert.assertTrue(aboutUsPage.getCustomModules().isDisplayed(), "CustomModules is present");
    }

    @Test
    public void technologyStacksIsPresent() {
        Assert.assertTrue(aboutUsPage.getTechnologyStacks().isDisplayed(), "TechnologyStacks is present");
    }

    @Test
    public void inspiredUsersIsPresent() {
        Assert.assertTrue(aboutUsPage.getInspiredUsers().isDisplayed(), "InspiredUsers is present");
    }

    @Test
    public void carouselIconIsPresent() {
        Assert.assertTrue(aboutUsPage.getCarouselSwiper().isDisplayed(), "CarouselIcon is present");
    }



    @Test
    public void messengerIsPresent() {
        Assert.assertTrue(aboutUsPage.getMessenger().isDisplayed(), "Messenger is present");
    }

    @Test
    public void discordIsPresent() {
        Assert.assertTrue(aboutUsPage.getDiscord().isDisplayed(), "Discord is present");
    }

    @Test
    public void linkedInIsPresent() {
        Assert.assertTrue(aboutUsPage.getLinkedIn().isDisplayed(), "LinkedIn is present");
    }

    @Test
    public void youtubeIsPresent() {
        Assert.assertTrue(aboutUsPage.getYoutube().isDisplayed(), "Youtube is present");
    }

    @Test
    public void carouselItemIsPresent() {
        Assert.assertTrue(aboutUsPage.getCarouselItem().isDisplayed(), "CarouselItem is present");
    }

    @Test
    public void checkBrokenImagesTest(){
        basePage.checkBrokenImages();
    }

}