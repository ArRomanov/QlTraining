import org.openqa.selenium.WebDriver;

public class ResultsListPage extends AbstractPage {

    private static String SEARCH_RESULTS_LIST = "//div[@class='serp-list']";
    private static String ONE_OF_LINK_FROM_RESULT_LIST = "//li[@class='serp-item'][%s]//a[contains(@class,'link_cropped_no')]";
    private static String RESULTS_WAS_FOUND_FLAG = "//div[@class='serp-adv__found']";

    public ResultsListPage(WebDriver driver) {
        super(driver);
    }

    public void openLinkAndSwitchToIt(String numOfLink) {
        this
                .waitUntilElementIsVisible(SEARCH_RESULTS_LIST, 5)
                .clickLMB(String.format(ONE_OF_LINK_FROM_RESULT_LIST, numOfLink))
                .switchToOtherTab();
    }

    public void assertIsResultListPage() {
        this.checkDisplayedOfElement(RESULTS_WAS_FOUND_FLAG);
    }
}
