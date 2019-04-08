package factories;

import org.openqa.selenium.WebDriver;
import pages.HabrMainPage;
import pages.YandexMainPage;
import pages.YandexResultsPage;

public class PagesFactories {

    private WebDriver driver;
    private YandexMainPage yandexMainPage;
    private YandexResultsPage yandexResultPage;
    private HabrMainPage habrPage;

    public PagesFactories(String browser) throws WrongBrowserException {

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = WebDriverFactory.getSimpleChrome();
                break;
            case "firefox":
                driver = WebDriverFactory.getSimpleFirefox();
                break;
            default:
                throw new WrongBrowserException("Выбран неверный браузер.");

        }
    }

    public void destroyDriver() {
        driver.quit();
    }


    public HabrMainPage getHabrPage() {
        if (habrPage == null) {
            habrPage = new HabrMainPage(driver);
        }
        return habrPage;
    }

    public YandexResultsPage getYandexResultPage() {
        if (yandexResultPage == null) {
            yandexResultPage = new YandexResultsPage(driver);
        }
        return yandexResultPage;
    }

    public YandexMainPage getYandexMainPage() {
        if (yandexMainPage == null) {
            yandexMainPage = new YandexMainPage(driver);
        }
        return yandexMainPage;
    }

    public class WrongBrowserException extends Exception {
        WrongBrowserException() {
        }

        WrongBrowserException(String message) {
            super(message);
        }
    }


}
