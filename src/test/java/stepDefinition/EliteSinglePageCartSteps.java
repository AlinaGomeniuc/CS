package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Driver.*;

public class EliteSinglePageCartSteps {
    @When("Scroll to products area")
    public void scrollToProductsArea() {
        WebElement element = getElement(By.cssSelector("div.w3_agile_latest_arrivals > h3"));
        scrollPage(element);
    }

    @And("Click on {int} element ADD TO CART button")
    public void clickAddToCartButton(int nrElement) {
        String selector = String.format("div.w3_agile_latest_arrivals > div:nth-child(%d) input.button", nrElement+1);
        clickElement(By.cssSelector(selector));
    }

    @Then("Cart should contain 2 elements")
    public void checkCartSize() {
        int cartSize = getListElementSize(By.cssSelector("#PPMiniCart .minicart-item"));

        Assert.assertEquals(cartSize, 2);
    }




}