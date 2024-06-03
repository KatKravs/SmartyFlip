package smartyflip_testng.tests.donate;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.donate.DonatePage;
import smartyflip_testng.tests.TestBase;

public class DonatePageTests extends TestBase {
    private DonatePage donatePage;
    private BasePage basePage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        donatePage = new DonatePage(app.driver);
        basePage.goToPage(DonatePage.donatePageURL());
        basePage.isCurrentPage(DonatePage.donatePageURL(),true);
    }

    @Test
    public void donateHeaderTextIsPresent() {
       Assert.assertEquals(donatePage.getDonateHeaderText(),"Buy us a cup of coffee","Incorrect DonateHeaderText ");
    }

    @Test
    public void donateMaestroTextIsPresent() {
        Assert.assertEquals(donatePage.getDonateMaestroText(), "IBAN: 7777 8888 7777 9999", "Incorrect DonateMaestroText");
    }

    @Test
    public void donateMasterCardTextIsPresent() {
        Assert.assertEquals(donatePage.getDonateMasterCardText(), "7777 8888 7777 9999", "Incorrect DonateMasterCardText");
    }

    @Test
    public void donatePayPalTextIsPresent() {
        Assert.assertEquals(donatePage.getDonatePayPalText(), "smarty.flip@gmail.com", "Incorrect DonatePayPalText");
    }

    @Test
    public void donateBitcoinTextIsPresent() {
        Assert.assertEquals(donatePage.getDonateBitcoinText(), "smarty.flip@gmail.com", "Incorrect DonateBitcoinText");
    }

    @Test
    public void checkBrokenImagesTest(){
        basePage.checkBrokenImages();
    }
}