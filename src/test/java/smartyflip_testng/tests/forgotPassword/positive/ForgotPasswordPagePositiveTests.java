package smartyflip_testng.tests.forgotPassword.positive;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.forgotPassword.ForgotPasswordPage;
import smartyflip_testng.tests.TestBase;


public class ForgotPasswordPagePositiveTests extends TestBase {

    private BasePage basePage;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        forgotPasswordPage = new ForgotPasswordPage(app.driver);
        basePage.goToPage(ForgotPasswordPage.forgotPasswordPageURL());
        basePage.isCurrentPage(ForgotPasswordPage.forgotPasswordPageURL(),true);
    }

    @Test
    public void sendWithValidLogin() {
        forgotPasswordPage.enterLoginInForgotPasswordPage("admin");
        forgotPasswordPage.enterEmailInForgotPasswordPage("admin@gmail.com");
        forgotPasswordPage.clickSendPasswordButton();
        Assert.assertTrue(basePage.isAlertPresent());
    }

    @Test
    public void textDontWorryIsPresent() {
        Assert.assertTrue(forgotPasswordPage.getTextDontWorry().isDisplayed(), "Text Dont Worry is present");
    }

    @Test
    public void textNoWeWillIsPresent() {
        Assert.assertTrue(forgotPasswordPage.getTextNoWeWill().isDisplayed(), "Text no we will solve this problem is present");
    }
}