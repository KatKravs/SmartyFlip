package smartyflip_testng.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public static final Duration WAIT_SEC = Duration.ofSeconds(5);




    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static String homePageURL() {
        return "http://localhost:5173/#/";
    }

    @FindBy(css = ".iconBanner")
    WebElement homePageTitleSmartyFlip;

    public boolean isHomePageLogoTitleDisplayed() {
        return homePageTitleSmartyFlip.isDisplayed();
    }

    @FindBy(xpath = "//h1[contains(text(),'Provides')]") //
    public WebElement homePageTitleDescription;

    public boolean isHomePageTitleDescriptionDisplayed() {
        return homePageTitleDescription.isDisplayed();
    }

    @FindBy(xpath = "//p[contains(text(),'invites')]")
    WebElement homePageInvitationText;

    public boolean isHomePageInvitationTextDisplayed() {
        return homePageInvitationText.isDisplayed();
    }

    @FindBy(id = "button-sign-in")
    WebElement signInLink;
    public HomePage clickOnSignInLink() {
        click(signInLink);
        return this;
    }

    @FindBy(xpath = "//h5[contains(text(),'Java')]")
    WebElement moduleJava;
    public void clickOnModuleJava() {
        scrollIntoView(moduleJava);
        click(moduleJava);
    }

    @FindBy(xpath = "//div[contains(@class,'customCard')][2]")
    WebElement modulePython;
    public void clickOnModulePython() {
        scrollIntoView(modulePython);
        click(modulePython);
    }

    public boolean isSignOutAfterLogin() {
        return signInLink.isDisplayed();
    }

    @FindBy(xpath = "//*[@id='basic-navbar-nav']/div[1]/a[3]")
    WebElement donateLink;
    public void clickOnDonateLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(donateLink));
        click(donateLink);
    }
}