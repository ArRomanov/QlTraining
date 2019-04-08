import factories.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    public WebDriver driver;

    @BeforeClass
    public void initDriver() {
        driver = WebDriverFactory.getSimpleWebdriver();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
