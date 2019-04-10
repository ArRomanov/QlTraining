package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class YandexResultsPage extends AbstractPage {

    private static final String SEARCH_RESULTS_LIST = "//div[@class='serp-list']";
    private static final String ONE_OF_LINK_FROM_RESULT_LIST = "//li[@class='serp-item'][%s]//a[contains(@class,'link_cropped_no')]";
    private static final String RESULTS_WAS_FOUND_FLAG = "//div[@class='serp-adv__found']";

    public YandexResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем {numOfLink} ссылку из списка результатов")
    public void openLinkAndSwitchToIt(String numOfLink) {
        this
                .waitUntilElementIsVisible(SEARCH_RESULTS_LIST, 5)
                .clickLMB(String.format(ONE_OF_LINK_FROM_RESULT_LIST, numOfLink))
                .switchToOtherTab();
    }

    @Step("Проверяем, что находимся на странице результатов поиска")
    public void assertIsResultListPage() {
        this.checkDisplayedOfElement(RESULTS_WAS_FOUND_FLAG);
    }
}
