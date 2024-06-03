package smartyflip_testng.pages.registration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;
import smartyflip_testng.pages.UserCredentials;

public class RegistrationPage extends BasePage {

    BasePage basePage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.basePage = new BasePage(driver);

    }


    public  String registrationPageURL() {
        return HomePage.homePageURL() + "registration";
    }

    public BasePage getBasePage() {
        return basePage;
    }

    @FindBy(id = "firstname")
    WebElement firsNameField;
    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passwordField;

    public void registerUser(String firstname, String lastName, String email, String login, String password) {
        pause(500);
        type(firsNameField, firstname);
        type(lastNameField, lastName);
        type(emailField, email);
        scrollIntoView(passwordField);
        type(loginField, login);
        type(passwordField, password);
    }

    public void registerUserValid (UserCredentials user) {
    }

    public WebElement getFirsNameField() {
        return firsNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }


    public void clickShowPasswordCheckbox() {
        clickOnElement(ElementType.CHECKBOX, "_checkbox_14yr2_1");
    }

//    public void clickRegistrationButton() {
//        pause(1500);
//        clickOnElement(ElementType.BUTTON, "submit");
//    }

    @FindBy(css = "#submit")
    WebElement submitButton;
    public void clickRegistrationButton() {
        scrollIntoView(submitButton,150);
        click(submitButton);
        pause(700);
    }



    @FindBy(css = "h2")
    WebElement greetingText;

    public void greetingTextIsPressent() {
        isElementPresent(greetingText, true);
    }


    @FindBy(xpath = "//span[contains(text(),'Invalid email address')]")
    WebElement errorEmailMessage;

    public RegistrationPage checkWrongEmailMessageIsPresent(String invalidEmailAddress) {
        emailField.sendKeys(Keys.ENTER);
        scrollIntoView(loginField);
        Assert.assertTrue(errorEmailMessage.getText().contains(invalidEmailAddress));
        return this;
    }


    @FindBy(xpath = "//span[contains(text(),'First name must ')]")
    WebElement errorFirstNameMessage;

    public RegistrationPage checkWrongFirstNameMessageIsPresent(String invalidFirstName) {
        firsNameField.sendKeys(Keys.ENTER);
        Assert.assertTrue(errorFirstNameMessage.getText().contains(invalidFirstName));
        return this;

    }

    @FindBy(xpath = "//span[contains(text(),'Last name must ')]")
    WebElement errorLastNameMessage;

    public RegistrationPage checkWrongLastNameMessageIsPresent(String invalidLastName) {
        lastNameField.sendKeys(Keys.ENTER);
        Assert.assertTrue(errorLastNameMessage.getText().contains(invalidLastName));
        return this;
    }


    @FindBy(xpath = "//span[contains(text(),'Username')]")
    WebElement errorLoginMessage;

    public RegistrationPage checkWrongLoginMessageIsPresent(String invalidLogin) {
        loginField.sendKeys(Keys.ENTER);
        scrollIntoView(passwordField);
        Assert.assertTrue(errorLoginMessage.getText().contains(invalidLogin));
        return this;

    }

    @FindBy(xpath = "//span[contains(text(),'Password')]")
    WebElement errorPasswordMessage;

    public RegistrationPage checkWrongPasswordMessageIsPresent(String invalidPassword) {
        passwordField.sendKeys(Keys.ENTER);
        scrollIntoView(submitButton);
        Assert.assertTrue(errorPasswordMessage.getText().contains(invalidPassword));
        return this;
    }
    @FindBy(xpath = "//span[contains(text(),'Required')]")
    WebElement requiredMessage;

    public RegistrationPage checkEmptyEmailMessageIsPresent(String emptyEmail) {
        emailField.sendKeys(Keys.ENTER);
        scrollIntoView(loginField);
        Assert.assertTrue(requiredMessage.getText().contains(emptyEmail));
        return this;
    }

    @FindBy(css = ".text-danger")
    WebElement existsMessage;

    public RegistrationPage checkIsExistsLoginMessageIsPresent(String existsLogin) {
        Assert.assertTrue(existsMessage.getText().contains(existsLogin));
        return this;

    }

    public RegistrationPage checkExistsEmailMessageIsPresent(String existsEmail) {
        scrollIntoView(existsMessage);
        Assert.assertTrue(existsMessage.getText().contains(existsEmail));
        return this;

    }

    public WebElement getErrorFirstNameMessage() {
        return errorFirstNameMessage;
    }

    public WebElement getErrorLastNameMessage() {
        return errorLastNameMessage;
    }
}