package smartyflip_testng.pages.createdModuls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;

public class CreatedModulsPage extends BasePage {
    public CreatedModulsPage(WebDriver driver) {
        super(driver);
    }
    public String modulesPageURL() {
        return HomePage.homePageURL() + "created-modules";
    }

    @FindBy(css = "h1")
    WebElement createdModulsText;
    public WebElement isTextCreatedModulsPresents() {
        return createdModulsText;
    }
}