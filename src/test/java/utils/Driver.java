package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


public class Driver {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public static void navigate(String url) {
        driver.get(url);
    }

    public static WebElement getElement(By selector) {
        return driver.findElement(selector);
    }

    public static int getListElementSize(By selector) {
        return driver.findElements(selector).size();
    }

    public static void clickElement(By selector) {
        getElement(selector).click();
    }

    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public static Long getYPosition() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (Long) executor.executeScript("return window.pageYOffset;");
    }

    public static String getAlertMessage(List<WebElement> elements) {
        for(WebElement element : elements) {
            String message = element.getAttribute("validationMessage");
            if (!message.isEmpty()) {
                return message;
            }
        }
        return null;
    }

    public static Object executeScript(String script, WebElement el) {
        return ((JavascriptExecutor)driver).executeScript(script, el);
    }

    public static void scrollPage(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

