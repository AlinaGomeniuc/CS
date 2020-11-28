package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;


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

    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}

