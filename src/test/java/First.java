import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class First extends Base {

    @Test
    @Description("Проверка поиска в Yandex")
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

    @Test
    @Description("Проверка поиска в Yandex (умышленный эксепшн теста)")
    public void searchHabrException() {
        pages.getYandexMainPage()
                .openYandex()
                .assertIsMainYandexPage()
                .performSearch("Exception")
                .openLinkAndSwitchToIt("1");
        pages.getHabrPage()
                .assertIsHabrMainPage();
    }
}
