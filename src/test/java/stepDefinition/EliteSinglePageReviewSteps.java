package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import static utils.Driver.*;


public class EliteSinglePageReviewSteps {

    @And("Populate review form")
    public void populateReviewForm(DataTable reviewInfo) throws InterruptedException {
        List<Map<String, String>> tableRows = reviewInfo.asMaps(String.class, String.class);
        Map<String, String> data = tableRows.get(0);

        String username = data.get("username");
        String email = data.get("email");
        String message = data.get("message");

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

    @And("Click on SEND button")
    public void clickOnSendButton() {
        clickElement(By.cssSelector("div.add-review > form > input[type=\"submit\"]:nth-child(4)"));
    }

    @Then("A warning message {string} appears")
    public void checkWarningMessage(String expected) {
        String actual = getAlertMessage(By.cssSelector(".add-review [name='Email']"));

        Assert.assertEquals(expected, actual);
    }

}
