package smartyflip_testng.pages.cabinet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import smartyflip_testng.pages.BasePage;
import smartyflip_testng.pages.HomePage;

import java.util.List;

public class CabinetPage extends BasePage {


    public CabinetPage(WebDriver driver) {
        super(driver);
    }

    public static final String SIGN_OUT_LINK = "Sign out";


    public String cabinetPageURL() {
        return HomePage.homePageURL() + "cabinet";
    }

    @FindBy(css = ".form-select")
    WebElement moduleContainer;

    public void selectModule() {
        click(moduleContainer);
        moduleContainer.sendKeys(Keys.ARROW_DOWN);
        moduleContainer.sendKeys(Keys.ENTER);
    }



    @FindBy(css = "h2")
    WebElement userName;

    public void userNameIsPresent() {
        isElementPresent(userName, true);

    }

    @FindBy(css = "h1")
    WebElement greeting;

    public void userGreetingTextPresent() {
        pause(1000);
        isElementPresent(greeting, true);
    }

    @FindBy(css = "div.col-sm-8 p")
    WebElement createButtonText;

    public void createYourOwnModuleButtonIsPresent() {
        isElementPresent(createButtonText, true);
    }


    @FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div[1]/div/button")
    WebElement createButton;
    public void createYourOwnModuleButtonIsClickable() {
//        clickOnElement(ElementType.XPATH, "//*[@id='root']/div/div/div[2]/div[2]/div[1]/div/button");
        scrollIntoView(createButton,-500);
        click(createButton);
    }

    @FindBy(css = ".imgCabinet")
    WebElement userImage;

    public void imageIsPresent() {
        isElementPresent(userImage, true);
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public CabinetPage checkBrokenImages() {

        System.out.println("We have " + images.size() + " images");

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("===================");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("===================");
                }
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
        return this;
    }

    @FindBy(id = "sign-out")
    WebElement signOutButton;

    public void isSignOutLinkPresent(String signout) {
        scrollIntoView(signOutButton);
        pause(500);
        Assert.assertTrue(signOutButton.getText().contains(signout));
    }
    @FindBy(id = "goToEditProfile")
    WebElement editButton;
    public void editProfileButtonIsClickable() {
        scrollToBottom();
        click(editButton);
    }
    @FindBy(id = "goToEditPassword")
    WebElement changePasswordButton;
    public void changePasswordButtonIsClickable() {
        scrollIntoView(changePasswordButton,250);
        click(changePasswordButton);
    }

    public void clickOnSignOutButton() {
        scrollIntoView(signOutButton);
        pause(500);
        click(signOutButton);
    }
}