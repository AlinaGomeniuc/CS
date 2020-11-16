package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import static utils.Driver.*;


public class EliteSinglePageReplySteps {

    private Long yPosition1;

    @When("Click on REVIEW tab")
    public void clickOnReviewTab() {
        clickElement(By.xpath("//*[@id=\"horizontalTab\"]/ul/li[2]"));
    }

    @When("Click on REPLY button")
    public void clickOnReplyButton() throws InterruptedException {
        Thread.sleep(2000);
        yPosition1 = getYPosition();
        clickElement(By.cssSelector("div.bootstrap-tab-text-grid-right > ul > li:nth-child(2) > a > i"));
    }

    @Then("A review reply form appears")
    public void checkAppearanceReviewForm() {
        Long yPosition2 = getYPosition();

        Assert.assertTrue("The Y position has increased ", yPosition2 > yPosition1);
    }
}