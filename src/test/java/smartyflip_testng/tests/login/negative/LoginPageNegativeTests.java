package smartyflip_testng.tests.login.negative;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.DataProviderClass;
import smartyflip_testng.pages.DataRandom;
import smartyflip_testng.pages.UserCredentials;
import smartyflip_testng.pages.login.LoginPage;
import smartyflip_testng.tests.TestBase;

public class LoginPageNegativeTests extends TestBase {
    private final String existLoginInvalidPasswordData = "existLoginInvalidPasswordData";
    private final String invalidLoginValidPasswordData = "invalidLoginValidPasswordData";
    private final String validNotRegisteredLoginValidPasswordData = "validNotRegisteredLoginValidPasswordData";

    private BasePage basePage;
    private LoginPage loginPage;
    UserCredentials userWithValidLoginInvalidPassword = UserCredentials.userWithValidLoginInvalidPassword();
    UserCredentials userWithInvalidLoginValidPassword = UserCredentials.userWithInvalidLoginValidPassword();
    UserCredentials userWithEmptyLoginValidPassword = UserCredentials.userWithEmptyLoginValidPassword();
    UserCredentials userWithValidLoginEmptyPassword = UserCredentials.userWithValidLoginEmptyPassword();



    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        loginPage = new LoginPage(app.driver);
        basePage.goToPage(LoginPage.loginPageURL());
        basePage.isCurrentPage(LoginPage.loginPageURL(), true);
        app.driver.manage().window().maximize();
    }

    @Test(dataProvider = existLoginInvalidPasswordData, dataProviderClass = DataProviderClass.class)
    public void existLoginInvalidPasswordData(String existLogin, String invalidPassword) {
        loginPage.login(existLogin, invalidPassword);
        loginPage.clickCheckbox();
        loginPage.clickOnLoginButton();
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageIncorrect(), "Username or password is incorrect", "Correct error message is displayed");
    }

    @Test(dataProvider = invalidLoginValidPasswordData, dataProviderClass = DataProviderClass.class)
    public void invalidLoginValidPasswordData(String invalidLogin, String validPassword) {
        loginPage.login(invalidLogin, validPassword);
        loginPage.clickOnLoginButton();
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageIncorrect(), "Username or password is incorrect", "Correct error message is displayed");
    }

    @Test(dataProvider = validNotRegisteredLoginValidPasswordData, dataProviderClass = DataProviderClass.class)
    public void validNotRegisteredLoginValidPasswordData(String validNotRegisteredLogin, String validPassword) {
        loginPage.login(validNotRegisteredLogin, validPassword);
        loginPage.clickOnLoginButton();
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageIncorrect(), "Username or password is incorrect", "Correct error message is displayed");
    }

    @Test
    public void loginWithInvalidLogin() {
        loginPage.login(userWithInvalidLoginValidPassword.getLogin(), userWithInvalidLoginValidPassword.getPassword());
        loginPage.clickOnLoginButton();
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageIncorrect(), "Username or password is incorrect", "Correct error message is displayed");
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.login(userWithValidLoginInvalidPassword.getLogin(), userWithValidLoginInvalidPassword.getPassword());
        loginPage.clickOnLoginButton();
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageIncorrect(), "Username or password is incorrect", "Correct error message is displayed");
    }
    @Test
    public void loginWithEmptyLogin() {
        loginPage.login(userWithEmptyLoginValidPassword.getLogin(), userWithEmptyLoginValidPassword.getPassword());
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageEmptyFieldLogin(), "Username cannot be empty", "Correct error message is displayed");
    }
    @Test
    public void loginWithEmptyPassword() {
        loginPage.login(userWithValidLoginEmptyPassword.getLogin(), userWithValidLoginEmptyPassword.getPassword());
        loginPage.clickCheckbox();
        basePage.pause(1500);
        Assert.assertEquals(loginPage.getErrorMessageEmptyFieldPassword(), "Password cannot be empty", "Correct error message is displayed");
    }

    @Test(invocationCount = 5)
    public void loginUserWithValidRandomDataPositive() {
        String randomLogin = DataRandom.getValidLogin();
        String randomPassword = DataRandom.getValidPassword();
        loginPage.login(randomLogin, randomPassword);
        loginPage.clickCheckbox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageIncorrect(), "Username or password is incorrect", "Correct error message is displayed");
    }

}