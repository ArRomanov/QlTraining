import factories.PagesFactories;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class Base {

    public PagesFactories pages;

    @BeforeClass
    public void initDriver() throws PagesFactories.WrongBrowserException {
        pages = new PagesFactories("chrome");
    }

    @AfterClass
    public void tearDown() {
        pages.destroyInstance();
    }
}
