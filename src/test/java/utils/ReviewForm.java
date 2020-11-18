package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.Driver.getElement;

public class ReviewForm {

    public static void fillReviewWithData(String username, String email, String message) throws InterruptedException {
        WebElement usernameField = getElement(By.cssSelector("div.add-review > form > input[type=\"text\"]:nth-child(1)"));
        usernameField.sendKeys(username);
        Thread.sleep(1500);
        WebElement emailField = getElement(By.cssSelector("div.add-review > form > input[type=\"email\"]:nth-child(2)"));
        emailField.sendKeys(email);
        Thread.sleep(1500);
        WebElement messageField = getElement(By.cssSelector("div.add-review > form > textarea"));
        messageField.sendKeys(message);
        Thread.sleep(1500);
    }

    public static List<WebElement> getInputFields() {
        return new ArrayList<WebElement>(){{
            add(getElement(By.cssSelector("div.add-review > form > input[type=\"text\"]:nth-child(1)")));
            add(getElement(By.cssSelector("div.add-review > form > input[type=\"email\"]:nth-child(2)")));
            add(getElement(By.cssSelector("div.add-review > form > textarea")));
        }};
    }
}
