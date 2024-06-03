package smartyflip_testng.pages.aboutUs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smartyflip_testng.pages.BasePage;

import java.util.List;

import static smartyflip_testng.pages.HomePage.homePageURL;


public class AboutUsPage extends BasePage {
    private WebDriver driver;

    public AboutUsPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public static String aboutUsPageURL() {
        return homePageURL() + "about";
    }
    @FindBy(xpath = "//a[contains(text(),'About Us')]")
    WebElement aboutUsHeader;


    public WebElement getAboutUsHeader() {
        return aboutUsHeader;
    }

    @FindBy(xpath = "//*[@id='root']/div/header/nav/div/img")
    WebElement getSmartyFlipSmallIcon;

    public WebElement getSmartyFlipSmallIcon() {
        return getSmartyFlipSmallIcon;
    }

    @FindBy(css = ".iconBanner")
    WebElement getSmartyFlipBigIcon;

    public WebElement getSmartyFlipBigIcon() {
        return getSmartyFlipBigIcon;
    }
    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/div/h3[1]")
    WebElement aboutUsHistory;

    public WebElement getAboutUsContent() {
        return aboutUsHistory;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div[1]/div")
    WebElement questionCards;

    public WebElement getQuestionCards() {
        return questionCards;
    }
    @FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[2]/div")
    WebElement customModules;

    public WebElement getCustomModules() {
        return customModules;
    }
    @FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[3]/div/div")
    WebElement technologyStacks;

    public WebElement getTechnologyStacks() {
        return technologyStacks;
    }
    @FindBy(xpath = "//*[@id='root']/div/div/div[3]/div/div/div[4]/div")
    WebElement inspiredUsers;

    public WebElement getInspiredUsers() {
        return inspiredUsers;
    }

    @FindBy(css = ".carousel-control-prev-icon")
    WebElement carouselSwiper;


    public WebElement getCarouselSwiper() {

        return carouselSwiper;
    }

    @FindBy(css = ".active.carousel-item")
    WebElement carouselItem;

    public WebElement getCarouselItem() {
        return carouselItem;
    }

    @FindBy(css = ".col-sm-3.p-3:nth-child(1)")
    WebElement messenger;

    public WebElement getMessenger() {
        return messenger;
    }
    @FindBy(css = ".col-sm-3.p-3:nth-child(2)")
    WebElement discord;

    public WebElement getDiscord() {
        return discord;
    }
    @FindBy(css = ".col-sm-3.p-3:nth-child(3)")
    WebElement linkedIn;

    public WebElement getLinkedIn() {
        return linkedIn;
    }

    @FindBy(css = ".col-sm-3.p-3:nth-child(4)")
    WebElement youtube;


    public WebElement getYoutube() {
        return youtube;
    }


}