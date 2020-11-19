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
import static utils.ReviewForm.*;


public class EliteSinglePageReviewSteps {

    @And("Populate review form")
    public void populateReviewForm(DataTable reviewInfo) throws InterruptedException {
        List<Map<String, String>> tableRows = reviewInfo.asMaps(String.class, String.class);
        Map<String, String> data = tableRows.get(0);

        String username = data.get("username");
        String email = data.get("email");
        String message = data.get("message");

        fillReviewWithData(username, email, message);
    }

    @And("Populate review form with {string} {string} {string}")
    public void populateReviewForm(String username, String email, String message) throws InterruptedException {
        fillReviewWithData(username, email, message);
    }

    @And("Click on SEND button")
    public void clickOnSendButton() {
        clickElement(By.cssSelector("div.add-review > form > input[type=\"submit\"]:nth-child(4)"));
    }

    @Then("A warning message {string} appears")
    public void checkWarningMessage(String expected) {
        String actual = getAlertMessage(getInputFields());
        Assert.assertEquals(expected, actual);
    }

    @Then("The review is posted")
    public void postReviewForm() throws InterruptedException {
        // check for absence of error
        Thread.sleep(2000);
        WebElement pageHeader = getElement(By.cssSelector("div.header > h1"));
        boolean isErrorHeaderPresent = isElementPresent(pageHeader);

        Assert.assertFalse("Error header is not present", isErrorHeaderPresent);
    }
}
