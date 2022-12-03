package tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import helpers.ScreenshotHelper;
import helpers.WindowHelper;
import pages.AppliancesPage;
import pages.KitchenAppliancesPage;
import pages.StartPage;
import tests.matchers.AppliancesPageMatcher;
import tests.matchers.KitchenAppliancesPageMatcher;


public class CaseOneTest extends BaseTest {

    private Logger logger = LogManager.getLogger(CaseOneTest.class);

    @Test
    public void firstTest() {
        // Arrange
        String expectedTitle = "Бытовая техника";
        String expectedTitle2 = "Техника для кухни";
        String expectedLink = "Собрать свою кухню";
        int expectedSize = 5;

        // Act
        AppliancesPage appliancesPage = getAppliancesPage();
        AppliancesPageMatcher appliancesPageMatcher = new AppliancesPageMatcher(appliancesPage);

        // Assert
        // Проверка отображения текста Бытовая техника
        appliancesPageMatcher.checkPageTitleText(expectedTitle);

        // Act
        // Переход по ссылке Техника для кухни
        appliancesPage.getLinkKitchenAppliances().click();
        ScreenshotHelper.makeScreenshot();
        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);
        KitchenAppliancesPageMatcher kitchenAppliancesPageMatcher = new KitchenAppliancesPageMatcher(kitchenAppliancesPage);


        // Assert
        // Проверка отображения текста Техника для кухни
        kitchenAppliancesPageMatcher.checkTextKitchenAppliances(expectedTitle2);
        // Проверка отображения текста Техника для кухни
        kitchenAppliancesPageMatcher.checkTextMakeKitchen(expectedLink);

        // Act
        // Вывод в логи названия всех категорий страницы 'Техника для кухни'
        kitchenAppliancesPage.getElementsKitchenAppliances();

        // Assert
        // Проверка, что количество категорий больше 5
        kitchenAppliancesPageMatcher.checkSizeKitchenAppliances(expectedSize);
    }


    public AppliancesPage getAppliancesPage() {

        // Открытие сайта DNS
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");

        // Вывод в логи заголовка страницы
        logger.info("Заголовок - " + startPage.getPageTitle());

        // Вывод в логи текущего URL
        logger.info("Текущий URL - " + startPage.getCurrentURL());

        // Вывод в логи размера окна браузера
        WindowHelper.getWindowWidth();
        WindowHelper.getWindowHeight();

        // Нажатие кнопки всё верно для дальнейшего тестирования
        startPage.getOkayButton().click();
        ScreenshotHelper.makeScreenshot();

        // Переход по ссылке Бытовая техника;
        startPage.getAppliancesLink().click();
        ScreenshotHelper.makeScreenshot();

        return new AppliancesPage(driver);
    }
}