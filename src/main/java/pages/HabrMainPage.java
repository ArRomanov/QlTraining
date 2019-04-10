package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HabrMainPage extends AbstractPage {

    private static final String HABR_MAIN_LOGO = "//a[@href='https://habr.com/ru/' and @class='logo']";
    private static final String HABR_TAB_TITLE = "Лучшие публикации за сутки / Хабр";

    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что находимся на странице хабра")
    public HabrMainPage assertIsHabrMainPage() {
        this
                .waitUntilElementIsVisible(HABR_MAIN_LOGO, 5)
                .checkTitle(HABR_TAB_TITLE);
        return this;
    }

    @Step("Возвращаемся на страницу с результатами поиска")
    public YandexResultsPage reurnToSearchResultPage() {
        this.switchToOtherTab();
        return new YandexResultsPage(driver);
    }
}