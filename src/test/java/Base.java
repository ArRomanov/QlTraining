import factories.PagesFactories;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    public PagesFactories pages;

    @BeforeClass
    public void initDriver() throws PagesFactories.WrongBrowserException {
        pages = new PagesFactories("chrome");
    }

    @AfterClass
    public void closeBrowser() {
        pages.destroyDriver();
    }
}
