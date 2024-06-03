package smartyflip_testng.tests.cabinet;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.cabinet.CabinetPage;
import smartyflip_testng.pages.createdModuls.CreatedModulsPage;
import smartyflip_testng.pages.editProfile.EditProfilePage;
import smartyflip_testng.pages.login.LoginPage;
import smartyflip_testng.tests.TestBase;

public class CabinetPagePositiveTests extends TestBase {
    BasePage basePage;
    EditProfilePage editProfilePage;
    CabinetPage cabinetPage;
    LoginPage loginPage;
    CreatedModulsPage modulsPage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        loginPage = new LoginPage(app.driver);
        cabinetPage = new CabinetPage(app.driver);
        modulsPage = new CreatedModulsPage(app.driver);
        editProfilePage = new EditProfilePage(app.driver);
        basePage.goToPage(LoginPage.loginPageURL());
        loginPage.login("user", "User1234!");
        loginPage.clickCheckbox();
        loginPage.clickOnLoginButton();
    }

    @Test
    public void signOutLinkIsPresent() {
        cabinetPage.isSignOutLinkPresent("Sign out");
    }


    @Test
    public void userNameIsPresent() {
        cabinetPage.userNameIsPresent();
    }

    @Test
    public void userGreetingTextIsPresent() {
        cabinetPage.userGreetingTextPresent();
    }

    @Test
    public void createYourOwnModuleButton() {
        cabinetPage.createYourOwnModuleButtonIsPresent();
        cabinetPage.createYourOwnModuleButtonIsClickable();
        Assert.assertTrue(modulsPage.isTextCreatedModulsPresents().isDisplayed());
    }

    @Test
    public void userBrokenImageTest() {
        cabinetPage.imageIsPresent();
        basePage.checkBrokenImages();
    }

    @Test
    public void editProfileButton() {
        cabinetPage.editProfileButtonIsClickable();
        editProfilePage.isTextEditPresents("Edit your profile");
    }

    @Test
    public void changePasswordButton() {
        cabinetPage.changePasswordButtonIsClickable();
        editProfilePage.isTextEditPresents("Edit your password");
    }

    @AfterMethod
    public void postCondition(){
        basePage.refreshPage();
    }
}