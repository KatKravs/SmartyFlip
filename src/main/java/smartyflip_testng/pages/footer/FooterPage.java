package smartyflip_testng.pages.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smartyflip_testng.pages.BasePage;


public class FooterPage extends BasePage {
    private WebDriver driver;

    public FooterPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id='root']/div/footer/div/div[1]/img")
    WebElement smallSmartyFlipIcon;

    public WebElement getSmallSmartyFlipIcon() {
        return smallSmartyFlipIcon;
    }
    @FindBy(xpath = "//a[@href='mailto:info@smartyflip.de']")
    WebElement smartyFlipGmailCom;

    public WebElement getSmartyFlipGmailCom() {
        return smartyFlipGmailCom;
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div[5]/div/h1")
    WebElement hereCould;

    public WebElement getTextHereCouldBeYourAdvertisement() {
        return hereCould;
    }


}