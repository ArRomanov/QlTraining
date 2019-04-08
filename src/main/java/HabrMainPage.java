import org.openqa.selenium.WebDriver;

public class HabrMainPage extends AbstractPage {

    private static String HABR_MAIN_LOGO = "//a[@href='https://habr.com/ru/' and @class='logo']";
    private static String HABR_TAB_TITLE = "Лучшие публикации за сутки / Хабр";

    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    public HabrMainPage assertIsHabrMainPage() {
        this
                .waitUntilElementIsVisible(HABR_MAIN_LOGO, 5)
                .checkTitle(HABR_TAB_TITLE);
        return this;
    }

    public ResultsListPage reurnToSearchResultPage() {
        this.switchToOtherTab();
        return new ResultsListPage(driver);
    }
}