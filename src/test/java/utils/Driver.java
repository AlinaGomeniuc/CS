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

    public static String getAlertMessage(String fieldName) {
        return getElement(By.name(fieldName)).getAttribute("validationMessage");
    }

    public static boolean isEmailValidationMessageDisplayed() {
        return !(Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;",
                getElement(By.name("Email")));
    }
}

