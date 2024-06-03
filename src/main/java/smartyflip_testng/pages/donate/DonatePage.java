package smartyflip_testng.pages.donate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;

public class DonatePage extends BasePage {

    public DonatePage(WebDriver driver) {
        super(driver);
    }

    public static String donatePageURL() {
        return HomePage.homePageURL() + "donate";
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div/h1[1]")
    WebElement donateHeader;
    public String getDonateHeaderText() {
        return donateHeader.getText();
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div/div[1]/div")
    WebElement donateMaestro;
    public String getDonateMaestroText() {
        return donateMaestro.getText();
    }
    @FindBy(xpath = "//*[@id='root']/div/div/div/div[2]/div")
    WebElement donateMasterCard;

    public String getDonateMasterCardText() {
        return donateMasterCard.getText();
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div/div[3]/div")
    WebElement donatePayPal;
    public String getDonatePayPalText() {
        return donatePayPal.getText();
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div/div[4]")
    WebElement donateBitcoin;
    public String getDonateBitcoinText() {
        return donateBitcoin.getText();
    }

    @FindBy(xpath = "//*[@id='root']/div/div/div/img")
    public WebElement donatePageTitleAuctions;

    public boolean isDonatePageTitleDisplayed() {
        return donatePageTitleAuctions.isDisplayed();
    }





}
