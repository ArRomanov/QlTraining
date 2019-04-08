import org.openqa.selenium.WebDriver;

public class YandexMainPage extends AbstractPage {

    private static String YANDEX_URL = "https://yandex.ru";
    private static String YANDEX_MAIN_LOGO = "//div[@class='home-logo__default']";
    private static String SEARCHING_START_BUTTON = "//button[contains(@class,'button_theme_websearch')]";
    private static String SEARCHING_QUERY_TEXT_FIELD = "//input[@aria-label='Запрос']";

    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    public YandexMainPage openYandex() {
        driver.get(YANDEX_URL);
        this.waitUntilElementIsVisible(YANDEX_MAIN_LOGO, 5);
        return this;
    }

    public YandexMainPage assertIsMainYandexPage() {
        this.checkTitle("Яндекс");
        return this;
    }

    public ResultsListPage performSearch(String searchQuery) {
        this
                .waitUntilElementIsVisible(SEARCHING_START_BUTTON, 3)
                .setTextInField(SEARCHING_QUERY_TEXT_FIELD, searchQuery)
                .clickLMB(SEARCHING_START_BUTTON);
        return new ResultsListPage(driver);
    }
}
