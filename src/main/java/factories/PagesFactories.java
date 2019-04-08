package factories;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.HabrMainPage;
import pages.YandexMainPage;
import pages.YandexResultsPage;

import java.io.File;
import java.io.IOException;

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

    @Attachment(value = "SCREENSHOT", type = "image/png")
    public byte[] attachScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        return Files.toByteArray(screenshot);
    }

    @Step("Закрываем браузер")
    public void destroyInstance() {
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
