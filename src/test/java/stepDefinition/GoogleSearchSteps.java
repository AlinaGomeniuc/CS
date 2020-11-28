package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Driver.*;

public class GoogleSearchSteps {
    @When("Populate URL box with {string}")
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

    @Given("The google page is loaded")
    public void navigateGooglePage() {
        navigate("https://www.google.co.in");
    }

    @When("Populate search box with {string}")
    public void populateSearchBox(String searchInput) {
        WebElement searchBar = getElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchBar.sendKeys(searchInput);
    }

    @And("Hit ENTER key")
    public void hitEnterKey() throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchBar = getElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchBar.sendKeys(Keys.RETURN);
    }

    @Then("Present list of 10 search result")
    public void presentSearchResult() throws InterruptedException {
        Thread.sleep(2000);
        int list_size = getListElementSize(By.cssSelector("#rso > div"));

        Assert.assertEquals(9, list_size);
    }

    @Then("Nothing happens")
    public void checkPageRedirection() {
        String currentLink = getCurrentURL();

        Assert.assertEquals("https://www.google.co.in/", currentLink);
    }

    @Then("The link {string} appears")
    public void checkDidYouMeanLink(String link) throws InterruptedException {
        Thread.sleep(2000);
        WebElement presentLink = getElement(By.xpath("//*[@id=\"taw\"]/div[2]/div"));
        String linkText = presentLink.getText();

        assertThat(linkText, containsString(link));
    }
}
