package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Driver.*;

public class GoogleSearchSteps {
    @When("Populate URL box with \"([^\"]*)\"$")
    public void populateURLBox(String url) throws InterruptedException {
        Thread.sleep(2000);
        navigate(url);
        Thread.sleep(2000);
    }

    @Then("Redirects to google main page")
    public void redirectsToMainPage() throws InterruptedException {
        Thread.sleep(1000);
        WebElement google_logo = getElement(By.cssSelector("#hplogo"));
        boolean isGoogleLogoDisplayed = isElementPresent(google_logo);

        Assert.assertTrue("Google logo is displayed", isGoogleLogoDisplayed);
    }
}
