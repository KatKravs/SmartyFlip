package smartyflip_testng.tests.forgotPassword.negative;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.DataProviderClass;
import smartyflip_testng.pages.forgotPassword.ForgotPasswordPage;
import smartyflip_testng.pages.registration.RegistrationPage;
import smartyflip_testng.tests.TestBase;


public class ForgotPasswordPageNegativeTests extends TestBase {

    private BasePage basePage;
    private ForgotPasswordPage forgotPasswordPage;
    private RegistrationPage registrationPage;


    private final String validLoginInvalidEmailData = "validLoginInvalidEmailData";
    private final String invalidLoginValidEmailData = "invalidLoginValidEmailData";

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        forgotPasswordPage = new ForgotPasswordPage(app.driver);
        registrationPage = new RegistrationPage(app.driver);
        basePage.goToPage(ForgotPasswordPage.forgotPasswordPageURL());
        basePage.isCurrentPage(ForgotPasswordPage.forgotPasswordPageURL(),true);
    }


    @Test(dataProvider = validLoginInvalidEmailData, dataProviderClass = DataProviderClass.class)
    public void sendWithValidLoginInvalidEmail(String validLogin, String invalidEmail) {
        forgotPasswordPage.enterEmailInForgotPasswordPage(validLogin, invalidEmail);
        forgotPasswordPage.clickSendPasswordButton();
        basePage.pause(1500);
        Assert.assertFalse(basePage.isAlertPresent());

    }

    @Test(dataProvider = validLoginInvalidEmailData, dataProviderClass = DataProviderClass.class)
    public void sendWithValidLoginInvalidEmailWithAlert(String validLogin, String invalidEmail) {
        forgotPasswordPage.enterEmailInForgotPasswordPage(validLogin, invalidEmail);
        forgotPasswordPage.clickSendPasswordButton();
        basePage.pause(1500);
        Assert.assertFalse(basePage.isAlertPresent());
    }

    @Test(dataProvider = invalidLoginValidEmailData, dataProviderClass = DataProviderClass.class)
    public void sendWithInvalidLoginValidEmail(String invalidLogin, String validEmail) {
        forgotPasswordPage.enterEmailInForgotPasswordPage(invalidLogin, validEmail);
        forgotPasswordPage.clickSendPasswordButton();
        Assert.assertFalse(basePage.isAlertPresent());
    }


    @Test
    public void sendWithValidLoginEmptyEmail() {
        forgotPasswordPage.enterLoginInForgotPasswordPage("admin");
        forgotPasswordPage.enterEmailInForgotPasswordPage("");
        forgotPasswordPage.clickSendPasswordButton();
        basePage.pause(1500);
        Assert.assertFalse(basePage.isAlertPresent());


    }


}