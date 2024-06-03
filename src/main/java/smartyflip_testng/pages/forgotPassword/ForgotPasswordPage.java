package smartyflip_testng.pages.forgotPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;


public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public static String forgotPasswordPageURL() {
        return HomePage.homePageURL() + "login-reload";
    }

    @FindBy(css = "h2")
    WebElement dontWorry;

    public WebElement getTextDontWorry() {
        return dontWorry;
    }


    @FindBy(css = "p")
    WebElement noWeWill;

    public WebElement getTextNoWeWill() {
        return noWeWill;
    }

    @FindBy(id = "login")
    WebElement enterLoginField;

    public void enterLoginInForgotPasswordPage(String login) {
        type(enterLoginField, login);
    }


    @FindBy(id = "email")
    WebElement enterEmailField;

    public void enterEmailInForgotPasswordPage(String email) {
        type(enterEmailField, email);
    }

    public void enterEmailInForgotPasswordPage(String login, String email) {
        type(enterLoginField, login);
        type(enterEmailField, email);
    }

    public void clickSendPasswordButton() {
        clickOnElement(BasePage.ElementType.SEND, "send");
    }

    @FindBy(id = "send")
    public WebElement sendButton;

    public boolean isForgotPasswordPagePresentAfterClickOnForgotPasswordLinkInLoginPage() {
        return sendButton.isDisplayed();
    }
}