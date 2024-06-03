package smartyflip_testng.pages.editProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import smartyflip_testng.pages.BasePage;

public class EditProfilePage extends BasePage {

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(css = "h2")
    WebElement editMessage;

    public EditProfilePage isTextEditPresents(String editYourProfile) {

        Assert.assertTrue(editMessage.getText().contains(editYourProfile));
        return this;
    }


}