package smartyflip_testng.tests.login.positive;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.DataProviderClass;
import smartyflip_testng.pages.HomePage;
import smartyflip_testng.pages.cabinet.CabinetPage;
import smartyflip_testng.pages.forgotPassword.ForgotPasswordPage;
import smartyflip_testng.pages.login.LoginPage;
import smartyflip_testng.tests.TestBase;

public class LoginPagePositiveTests extends TestBase {

    private final String registeredUserValidData = "registeredUserValidData";
    private BasePage basePage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;
    private HomePage homePage;

    private CabinetPage cabinetPage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        loginPage = new LoginPage(app.driver);
        homePage = new HomePage(app.driver);
        cabinetPage = new CabinetPage(app.driver);
        forgotPasswordPage = new ForgotPasswordPage(app.driver);
        basePage.goToPage(LoginPage.loginPageURL());
        basePage.isCurrentPage(LoginPage.loginPageURL(), true);
        app.driver.manage().window().maximize();
        basePage.pause(1500);

    }

    @Test
    public void loginWithValidDataPositive() {
        loginPage.login("user", "User1234!");
        loginPage.clickOnLoginButton();
        basePage.pause(500);
        Assert.assertTrue(loginPage.isUserCabinetPresent().isDisplayed(), "User Cabinet is present");
    }


    @Test
    public void textWelcomeBackPresent() {
        Assert.assertTrue(loginPage.isTextWelcomeBackPresent(), "TextWelcomeBackPresent is present");
    }

    @Test
    public void textEnterEmailPasswordPresent() {
        Assert.assertTrue(loginPage.isTextEnterEmailPasswordPresent(), "TextEnterEmailPasswordPresent is present");
    }

    @Test(dataProvider = registeredUserValidData, dataProviderClass = DataProviderClass.class)
    public void registeredUserValidDataProviderPositive(String validLogin, String validPassword) {
        loginPage.login(validLogin, validPassword);
        loginPage.clickCheckbox();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isUserCabinetPresent().isDisplayed());
    }



    @Test
    public void correctUserNameDisplayedAfterLogin() {
        loginPage.login("user", "User1234!");
        loginPage.clickCheckbox();
        loginPage.clickOnLoginButton();
        basePage.pause(500);
        Assert.assertEquals(loginPage.getDisplayedUserName(), "John Doe", "Correct user name is displayed");
    }

    @Test
    public void signOutAfterLogin() {
        loginPage.login("user", "User1234!");
        loginPage.clickCheckbox();
        loginPage.clickOnLoginButton();
        cabinetPage.clickOnSignOutButton();
        Assert.assertTrue(homePage.isSignOutAfterLogin());
    }

    @Test
    public void forgotPasswordLinkIsPresent() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkPresent(), "Forgot Password button is present");
    }

    @Test
    public void clickOnForgotYourPasswordLink() {
        loginPage.login("user", "");
        loginPage.clickForgotPasswordLink();
        basePage.isCurrentPage(ForgotPasswordPage.forgotPasswordPageURL(), true);
        Assert.assertTrue(forgotPasswordPage.isForgotPasswordPagePresentAfterClickOnForgotPasswordLinkInLoginPage());
    }

}