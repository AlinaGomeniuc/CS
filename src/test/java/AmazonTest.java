import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AmazonTest {

    private WebDriver driver = new SafariDriver();
    private PageParser pageParser = new PageParser();

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @Test
    public void testAmazonPage() {
        pageParser.searchKeyword(driver,"computer");
        boolean isHeaderDisplayed = pageParser.isHeaderDisplayed(driver);

        Assert.assertTrue(isHeaderDisplayed);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
