import org.testng.annotations.Test;

public class First extends Base {

    @Test
    public void searchHabr() {
        YandexMainPage yandex = new YandexMainPage(driver);
        yandex
                .openYandex()
                .assertIsMainYandexPage()
                .performSearch("habr")
                .openLinkAndSwitchToIt("1");
        HabrMainPage habr = new HabrMainPage(driver);
        habr
                .assertIsHabrMainPage()
                .reurnToSearchResultPage()
                .assertIsResultListPage();
    }
}
