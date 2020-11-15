package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Driver.*;


public class EliteSinglePagePincodeSteps {

    @Given("Navigate to single page")
    public void navigateToSinglePage() {
        navigate("https://adoring-pasteur-3ae17d.netlify.app/single.html");
    }

    @When("Populate pincode input field with \"([^\"]*)\"$")
    public void populatePincodeField(String pincode) throws InterruptedException {
        Thread.sleep(2000);
        WebElement pincodeField = getElement(By.cssSelector("div.description > form > input[type=\"text\"]:nth-child(1)"));
        pincodeField.sendKeys(pincode);
        Thread.sleep(2000);
    }

    @And("Click on CHECK button")
    public void clickCheckButton() {
        clickElement(By.cssSelector("div.description > form > input[type=\"submit\"]:nth-child(2)"));
    }

    @Then("Redirects to a new page with required info")
    public void redirectsToNewPageWithInfo() throws InterruptedException {
        // check for absence of error
        Thread.sleep(2000);
        WebElement pageHeader = getElement(By.cssSelector("div.header > h1"));
        boolean isErrorHeaderPresent = isElementPresent(pageHeader);

        Assert.assertFalse("Is error header present", isErrorHeaderPresent);
    }
}

