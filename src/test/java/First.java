import org.testng.annotations.Test;

public class First extends Base {

    @Test
    public void searchHabr() {
        pages.getYandexMainPage()
                .openYandex()
                .assertIsMainYandexPage()
                .performSearch("habr")
                .openLinkAndSwitchToIt("1");
        pages.getHabrPage()
                .assertIsHabrMainPage()
                .reurnToSearchResultPage()
                .assertIsResultListPage();
    }
}
