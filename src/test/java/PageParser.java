import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageParser {

    public void searchKeyword(WebDriver driver, String keyword){
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys(keyword);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
    }

    public boolean isAmazonHeaderDisplayed(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]")).isDisplayed();
    }
}
