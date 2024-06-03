package smartyflip_testng.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;

import java.time.Duration;

import static smartyflip_testng.pages.BasePage.ElementType.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static String loginPageURL() {
        return HomePage.homePageURL() + "login";
    }

    private By userNameLocator = By.xpath("//*[@id='root']/div/div/div[2]/div[1]/div/h2");

    public String getDisplayedUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator));
        return userNameElement.getText();
    }

    @FindBy(css = "h2")
    WebElement welcomeBack;

    public boolean isTextWelcomeBackPresent() {
        return welcomeBack.isDisplayed();

    }

    @FindBy(css = "p")
    WebElement textEnterEmailPassword;

    public boolean isTextEnterEmailPasswordPresent() {
        return textEnterEmailPassword.isDisplayed();

    }

    @FindBy(id = "login")
    public WebElement userLogin;
    @FindBy(id = "pwd")

    public WebElement userPassword;

    public void login(String login, String password) {
        scrollIntoView(userLogin);
        type(userLogin, login);
        type(userPassword, password);
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[1]/div/div[1]/img")
    public WebElement cabinet;

    public WebElement isUserCabinetPresent() {
        return cabinet;
    }

    @FindBy(id = "forgot")
    public WebElement forgotPass;

    public boolean isForgotPasswordLinkPresent() {
        return forgotPass.isDisplayed();
    }

    @FindBy(id = "submit")
    WebElement signInButton;

    public void clickOnLoginButton() {
        signInButton.click();
    }

    public void clickCheckbox() {
        clickOnElement(CHECKBOX, "checkbox");
    }


    @FindBy(id = "forgot")
    WebElement forgotLink;
    public void clickForgotPasswordLink() {
        clickLinks(forgotLink);
    }

    public String getErrorMessageIncorrect() {
        WebElement errorMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Username or password is incorrect')]"));
        return errorMessageElement.getText();
    }

    public String getErrorMessageEmptyFieldPassword() {
        WebElement errorMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Password cannot be empty')]"));
        return errorMessageElement.getText();
    }

    public String getErrorMessageEmptyFieldLogin() {
        WebElement errorMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Username cannot be empty')]"));
        return errorMessageElement.getText();
    }

}