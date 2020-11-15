package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static WebDriver driver = new SafariDriver();

    @Before
    public void setUp() {
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

    public static void clickElement(By selector) {
        getElement(selector).click();
    }

    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }
}

