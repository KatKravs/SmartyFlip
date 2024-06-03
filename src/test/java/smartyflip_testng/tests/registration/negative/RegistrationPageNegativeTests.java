package smartyflip_testng.tests.registration.negative;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.DataProviderClass;
import smartyflip_testng.pages.cabinet.CabinetPage;
import smartyflip_testng.pages.registration.RegistrationPage;
import smartyflip_testng.tests.TestBase;

public class RegistrationPageNegativeTests extends TestBase {
    BasePage basePage;
    RegistrationPage registrationPage;
    CabinetPage cabinetPage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(app.driver);
        registrationPage = new RegistrationPage(app.driver);
        cabinetPage = new CabinetPage(app.driver);
        basePage.goToPage(registrationPage.registrationPageURL());
        basePage.isCurrentPage(registrationPage.registrationPageURL(), true);
        app.driver.manage().window().maximize();
    }

    @Test(dataProvider = "invalidNameData", dataProviderClass = DataProviderClass.class)
    public void validateFirstNameWithIncorrectData(String invalidFirstName) {
        basePage.validateField(registrationPage.getFirsNameField(), invalidFirstName, false);
        registrationPage.checkWrongFirstNameMessageIsPresent("Firstname must");
    }

    @Test(dataProvider = "invalidNameData", dataProviderClass = DataProviderClass.class)
    public void validateLastNameWithIncorrectData(String invalidLastName) {
        basePage.validateField(registrationPage.getLastNameField(), invalidLastName, false);
        registrationPage.checkWrongLastNameMessageIsPresent("Lastname must");
    }

    @Test(dataProvider = "invalidEMailData", dataProviderClass = DataProviderClass.class)
    public void validateEmailWithIncorrectData(String invalidEmail) {
        basePage.validateField(registrationPage.getEmailField(), invalidEmail, false);
        registrationPage.checkWrongEmailMessageIsPresent("Invalid email address");
    }

    @Test(dataProvider = "emptyFieldEMailData", dataProviderClass = DataProviderClass.class)
    public void validateEmailWithEmptyField(String emptyField) {
        basePage.validateField(registrationPage.getEmailField(), emptyField, false);
        registrationPage.checkEmptyEmailMessageIsPresent("Required");
    }

    @Test(dataProvider = "invalidPasswordData", dataProviderClass = DataProviderClass.class)
    public void validatePasswordWithIncorrectData(String invalidPassword) {
        basePage.validateField(registrationPage.getPasswordField(), invalidPassword, false);
        registrationPage.checkWrongPasswordMessageIsPresent("Password must");
    }


    @Test(dataProvider = "invalidLoginRegistrData", dataProviderClass = DataProviderClass.class)
    public void validateLoginWithIncorrectData(String invalidLoginRegistr) {
        basePage.validateField(registrationPage.getLoginField(), invalidLoginRegistr, false);
        registrationPage.checkWrongLoginMessageIsPresent("Username");
    }





    @Test
    public void registrationUserWithLoginExistsDataTest() {
        registrationPage.registerUser(
                "John",
                "Smith",
                "test@gmail.com",
                "user",
                "Hh12345$");
        registrationPage.clickShowPasswordCheckbox();
        registrationPage.clickRegistrationButton();
        registrationPage.checkIsExistsLoginMessageIsPresent("Registration failed! A user with this username already exists");
    }

    @Test
    public void registrationUserWithEmailExistsDataTest() {
        registrationPage.registerUser(
                "John",
                "Smith",
                "user@gmail.com",
                "john",
                "Kj1234h5!");
        registrationPage.clickShowPasswordCheckbox();
        registrationPage.clickRegistrationButton();
        registrationPage.checkExistsEmailMessageIsPresent("Registration failed! A user with this email already exists");


    }

    @Test
    public void registrationUserWithInvalidFirstNameDataTest() {
        registrationPage.registerUser(
                "2345",
                "Kravs",
                "user123@gmail.com",
                "user123",
                "Plgfd12!");
        registrationPage.clickShowPasswordCheckbox();
        registrationPage.clickRegistrationButton();
        Assert.assertTrue(registrationPage.getErrorFirstNameMessage().isDisplayed());


    }

    @Test
    public void registrationUserWithInvalidLastNameDataTest() {
        registrationPage.registerUser(
                "John",
                "1234",
                "user1235@gmail.com",
                "user1235",
                "Plgfd12!");
        registrationPage.clickShowPasswordCheckbox();
        registrationPage.clickRegistrationButton();
        Assert.assertTrue(registrationPage.getErrorLastNameMessage().isDisplayed());
    }

    @AfterMethod
    public void postCondition(){
        basePage.refreshPage();
    }
}