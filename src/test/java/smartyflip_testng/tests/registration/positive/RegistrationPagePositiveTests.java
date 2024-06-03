package smartyflip_testng.tests.registration.positive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.DataProviderClass;
import smartyflip_testng.pages.cabinet.CabinetPage;
import smartyflip_testng.pages.registration.RegistrationPage;
import smartyflip_testng.tests.TestBase;

import static smartyflip_testng.pages.cabinet.CabinetPage.SIGN_OUT_LINK;


public class RegistrationPagePositiveTests extends TestBase {

    BasePage basePage;
    RegistrationPage registrationPage;
    CabinetPage cabinetPage;


    @BeforeMethod
    public void precondition(){
        basePage = new BasePage(app.driver);
        registrationPage=new RegistrationPage(app.driver);
        cabinetPage = new CabinetPage(app.driver);
        basePage.goToPage(registrationPage.registrationPageURL());
        basePage.isCurrentPage(registrationPage.registrationPageURL(),true);
        app.driver.manage().window().maximize();
    }

    @Test(dataProvider = "validNewUserRegisterWithDataProvider", dataProviderClass = DataProviderClass.class)
    public void registeredUserValidDataProviderPositive(String firstname, String lastname, String email, String login, String password) {
        basePage.refreshPage();
        registrationPage.registerUser(firstname, lastname, email, login, password);
        registrationPage.clickShowPasswordCheckbox();
        registrationPage.clickRegistrationButton();
        cabinetPage.isSignOutLinkPresent(SIGN_OUT_LINK);
        cabinetPage.clickOnSignOutButton();
    }


    @Test
    public void registrationUserWithValidDataPositiveTest(){
        registrationPage.registerUser(
                "John",
                "Smith",
                "te5st1ada5@gmail.com",
                "Old7111",
                "Hh12345$");
        registrationPage.clickShowPasswordCheckbox();
        registrationPage.clickRegistrationButton();
        cabinetPage.isSignOutLinkPresent(SIGN_OUT_LINK);
        cabinetPage.clickOnSignOutButton();
    }

    @Test
    public void greetingTextIsPresent(){
        registrationPage.greetingTextIsPressent();
    }
}