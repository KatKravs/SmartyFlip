package smartyflip_testng.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static smartyflip_testng.pages.BasePage.ElementType.ID;
import static smartyflip_testng.pages.HomePage.homePageURL;

public class BasePage {
    protected WebDriver driver;
    FluentWait<WebDriver> wait;
    public static final Duration WAIT_SEC = Duration.ofSeconds(5);

    JavascriptExecutor js;

    public enum ElementType {
        XPATH, CSS, ID, CLASS, HREF, ROLE, LABEL, SPAN, BUTTON, P, ERROR_VALIDATION, PASSWORD_CONFIRM, LANGUAGE_SELECTOR, LANGUAGE_ITEM, CHECKBOX, FORGOT_PASSWORD, SIGN_IN_OUT_LINK, SIGN_IN_BUTTON, SEND
    }
    public BasePage() {

    }

    public WebElement getElement(ElementType type, String value) {
        By locator = getByFromType(type, value);
        try {
            waitForElementToAppear(type, value, true, 5);
            return driver.findElement(locator);
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not found with locator: " + locator, e);
        }
    }

    public WebElement getElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not found: " + element, e);
        }
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(200))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        PageFactory.initElements(driver, this);
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitUntilElementToBeClickable(element);
        element.click();
    }

    public void clickLinks(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void closeTab() {
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void testClickLink(WebElement urlToOpen, String urlToCompare) {
        String currentWindowHandle = driver.getWindowHandle();
        clickLinks(urlToOpen);
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {
            windowHandles.remove(currentWindowHandle);
            String newWindowHandle = windowHandles.iterator().next();
            driver.switchTo().window(newWindowHandle);
            isCurrentPage(urlToCompare, true);
            closeTab();
            driver.switchTo().window(currentWindowHandle);
        } else {
            isCurrentPage(urlToCompare, true);
        }
    }

    public void type(WebElement element, String text) {
        waitUntilElementToBeClickable(element);
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }


    public void isValidationErrorPresent(boolean validationStatus) {
        boolean isPresent = isElementPresent(BasePage.ElementType.ERROR_VALIDATION, "", validationStatus);
        assert isPresent == validationStatus : "Validation error present status does not match the expected status";
    }

    public void isCurrentPage(String expectedURL, boolean expectedStatus) {
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.endsWith("/#/")) {
            currentUrl = currentUrl.substring(0, currentUrl.length() - 1);
        }
        boolean isCurrent = currentUrl.equals(expectedURL);
        assert isCurrent == expectedStatus : "Current page status does not match the expected status";
    }

    public void goToPage(String pageURL) {
        driver.get(pageURL);
    }

    public WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToAppear(ElementType type, String value, boolean expectedStatus, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until((WebDriver d) -> isElementPresent(type, value, expectedStatus));
        } catch (TimeoutException e) {
            System.out.println("Element can't be found on the page in " + timeoutInSeconds + " seconds");
            throw new RuntimeException("The item didn't appear within the specified time", e);
        }
    }

//    public void changeLanguage(String language) {
//        click(waitForElement(By.cssSelector(HomePage.LANGUAGE_SELECTOR), 10));
//        click(waitForElement(By.xpath(String.format(HomePage.LANGUAGE_ITEM_XPATH, language)), 10));
//    }

    protected By getByFromType(ElementType type, String value) {
        switch (type) {
            case ID:
                return By.id(value);
            case XPATH:
                return By.xpath(value);
            case CSS:
                return By.cssSelector(value);
            case HREF:
                return By.xpath("//a[@href='" + value + "']");
            case ROLE:
                return By.xpath("//*[@role='" + value + "']");
            case LABEL:
                return By.xpath("//label[@id='" + value + "']/a");
            case CLASS:
                return By.className(value);
            case CHECKBOX:
                return By.id(value);
            case SEND:
                return By.id(value);
            case SPAN:
                return By.xpath("//span[@id='" + value + "']");
            case BUTTON:
                return By.id(value);
            case SIGN_IN_BUTTON:
                return By.id(value);
            case P:
                return By.xpath("//p[@id='" + value + "']");
            case SIGN_IN_OUT_LINK:
                return By.cssSelector(".me-3.pt-3.txtHeaderWeis");
            case FORGOT_PASSWORD:
                return By.id(value);
            case ERROR_VALIDATION:
                return By.cssSelector("[data-testid^='error_']");
//            case LANGUAGE_SELECTOR:
//                return By.cssSelector(LANGUAGE_SELECTOR);
//            case LANGUAGE_ITEM:
//                return By.xpath(String.format(LANGUAGE_ITEM_XPATH, value));
            default:
                throw new IllegalArgumentException("Invalid selector type: " + type);
        }
    }

    public void clickOnElement(ElementType type, String value) {
        By by = getByFromType(type, value);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (type == ElementType.CHECKBOX) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            click(element);
        }
    }

    public void isElementPresent(WebElement element, boolean expectedStatus) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(expectedStatus, "Element ["+ element + "] is not visible");
        } catch (TimeoutException e) {
            Assert.assertFalse(expectedStatus, "Element ["+ element + "] not be found for short time");
        } catch (NoSuchElementException e) {
            Assert.assertFalse(expectedStatus, "Element ["+ element + "] not be found");
        }
    }
    public boolean isElementPresent(ElementType type, String value, boolean expectedStatus) {
        By by = getByFromType(type, value);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            Assert.assertTrue(expectedStatus);
            return true;
        } catch (TimeoutException e) {
            Assert.assertFalse(expectedStatus, "Element ["+  type + ": " +  value + "] not be found for short time");
            return false;
        } catch (NoSuchElementException e) {
            Assert.assertFalse(expectedStatus, "Element ["+  type + ": " +  value + "] not be found");
            return false;
        }
    }

    public void isElementClickable(WebElement element, boolean expectedStatus) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Assert.assertTrue(expectedStatus, "Element " + element + " is not clickable");
        } catch (TimeoutException e) {
            Assert.assertFalse(expectedStatus, "Element " + element + " is not clickable for short time");
        } catch (NoSuchElementException e) {
            Assert.assertFalse(expectedStatus, "Element " + element + " not be found");
        }
    }

    public void isElementClickableGPT(WebElement element, boolean expectedStatus) {
        boolean isClickable = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isDisplayed() && element.isEnabled()) {
                String tagName = element.getTagName();
                isClickable = tagName.equals("a") || tagName.equals("button") ||
                        tagName.equals("input") || tagName.equals("select") ||
                        tagName.equals("textarea") || tagName.equals("label") ||
                        tagName.equals("option") || tagName.equals("area") ||
                        tagName.equals("details") || tagName.equals("summary") ||
                        (tagName.equals("div") && "button".equals(element.getAttribute("role"))) ||
                        (tagName.equals("span") && "button".equals(element.getAttribute("role")));
            }
        } catch (TimeoutException e) {
            isClickable = false;
        } catch (NoSuchElementException e) {
            isClickable = false;
        }
        Assert.assertEquals(isClickable, expectedStatus, "Element clickable status mismatch");
    }





    public void isElementClickable(By locator, Dimension resolution, boolean expectedStatus) {
        driver.manage().window().setSize(resolution);
        boolean isClickable;
        try {
            wait.withTimeout(WAIT_SEC)
                    .withTimeout(Duration.ofMillis(5000))
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            isClickable = true;
        } catch (TimeoutException e) {
            isClickable = false;
            System.err.println("TimeoutException: Element was not clickable within the specified wait time [" + WAIT_SEC.getSeconds() + "] seconds");
        } catch (NoSuchElementException e) {
            isClickable = false;
            System.err.println("NoSuchElementException: Element was not found");
        }
        Assert.assertEquals(isClickable, expectedStatus, "Element is clickable?");
    }

    public void isElementClickable(ElementType type, String value, boolean expectedStatus) {
        By locator = getByFromType(type, value);
        boolean isClickable;
        try {
            wait.withTimeout(WAIT_SEC)
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            isClickable = true;
        } catch (TimeoutException e) {
            isClickable = false;
            System.err.println("TimeoutException: Element was not clickable within the specified wait time [" + WAIT_SEC.getSeconds() + "] seconds");
        } catch (NoSuchElementException e) {
            isClickable = false;
            System.err.println("NoSuchElementException: Element was not found");
        }
        Assert.assertEquals(isClickable, expectedStatus, "Element is clickable?");
    }
    public void isElementClickable(ElementType type, String value, Dimension resolution, boolean expectedStatus) {
        By locator = getByFromType(type, value);
        isElementClickable(locator, resolution, expectedStatus);
    }


    public void validateField(WebElement getElement, String invalidData, boolean validationExpectation) {
        if (getElement == null) {
            throw new IllegalArgumentException("Element is invalid");
        }
        if (invalidData == null) {
            throw new IllegalArgumentException("Data is null");
        }
        type(getElement, invalidData);
        isValidationErrorPresent(validationExpectation);
    }

    public void setCheckboxFirma() {
        clickOnElement(ID, "checkbox_client_firma_switch");
    }

    public void clickLinkSameTab(String linkName) {
        if (linkName != null) {
            if (!linkName.startsWith("https://") && !linkName.startsWith("http://")) {
                linkName = homePageURL() + "/" + linkName;
            }
            driver.get(linkName);
        } else {
            throw new IllegalArgumentException("Invalid link name: " + linkName);
        }
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void switchToTab(int tabNumber) {
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[tabNumber]);
    }

    public void waitForPageLoadComplete() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageLoadInteractive() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("interactive"));
    }

    public void clickWithJS(WebElement element, int x, int y){
        js.executeScript("window.scrollBy(" + x + "," + y +")");
        click(element);
    }

    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //create ulr connection and get response code
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " Error occurred");
        }
    }

//    public void scrollIntoView(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }

    public void scrollIntoView(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible before scrolling: " + element, e);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible after scrolling: " + element, e);
        }
    }

    public void scrollIntoView(WebElement element, int offset) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible before scrolling: " + element, e);
        }
        ((JavascriptExecutor) driver).executeScript(
                "const element = arguments[0];" +
                        "const offset = arguments[1];" +
                        "element.scrollIntoView({ behavior: 'smooth', block: 'center' });" +
                        "window.scrollBy(0, offset);",
                element, offset
        );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible after scrolling: " + element, e);
        }
    }


    @FindBy(css = "img")
    List<WebElement> images;
    public BasePage checkBrokenImages() {
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

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;
    public BasePage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size() ; i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    public void hideToasters(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('.toast').forEach(el => el.style.display = 'none');");
    }

    public void checkBrokenLinksByCall(String url) {
        System.out.println(url);
        if (url == null || url.isEmpty()) {
            System.out.println("URL is either not configured for anchor tag or it is empty");
            return;
        }
        if (!url.startsWith(homePageURL())) {
            System.out.println("URL belongs to another domain, skipping it.");
            return;
        }
        try {
            HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            int respCode = huc.getResponseCode();

            if (respCode >= 400) {
                System.out.println(url + " is a broken link");
            } else {
                System.out.println(url + " is a valid link");
            }
            huc.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
