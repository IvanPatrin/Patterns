package tests;

import helpers.ScreenshotHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.ElectricStovesPage;
import pages.StartPage;
import pages.StovesPage;
import tests.matchers.ElectricStovesPageMatcher;
import tests.matchers.StartPageMatcher;

import java.util.ArrayList;
import java.util.List;


public class CaseTwoTest extends BaseTest {
    private Logger logger = LogManager.getLogger(CaseTwoTest.class);
    List<String> actualListAppliances;
    int actualCountMakeCooking;

    @Test
    public void SecondTest() {
        // Arrange
        List<String> expectedListAppliance = new ArrayList<>();
        expectedListAppliance.add("Встраиваемая техника");
        expectedListAppliance.add("Техника для кухни");
        expectedListAppliance.add("Техника для дома");
        int expectedCountMakeCooking = 5;
        int expectedCountStoves = 100;

        // Act
        StartPage startPage = getStartPage();
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);

        // Assert
        // Проверка на отображение ссылок (Встраиваемая техника, Техника для кухни, Техника для дома)
        startPageMatcher.checkListLinksAppliances(expectedListAppliance, actualListAppliances);
        // Проверка колиечства ссылок в подменю 'Приготовление пищи' больше 5
        startPageMatcher.checkSizeListCooking(expectedCountMakeCooking, actualCountMakeCooking);

        // Act
        StovesPage stovesPage = new StovesPage(driver);
        stovesPage.getLinkElectricStove().click();
        ScreenshotHelper.makeScreenshot();
        ElectricStovesPage electricStovesPage = new ElectricStovesPage(driver);
        ElectricStovesPageMatcher electricStovesPageMatcher = new ElectricStovesPageMatcher(electricStovesPage);

        // Assert
        // Проверка на отображение ссылок (Встраиваемая техника, Техника для кухни, Техника для дома)
        electricStovesPageMatcher.checkStoveCount(expectedCountStoves);


    }

    public StartPage getStartPage() {
        // Открытие сайта DNS
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");

        // Нажатие кнопки всё верно для дальнейшего тестирования
        startPage.getOkayButton().click();
        ScreenshotHelper.makeScreenshot();

        // Перемещение курсора на Бытавую технику
        startPage.getAppliancesLink().focusOnLink();
        ScreenshotHelper.makeScreenshot();

        // Получение ссылок для проверки
        actualListAppliances = startPage.getListLinksAppliances();

        // Перемещение курсор на Приготовление пищи
        startPage.getCookingLink().focusOnLink();
        ScreenshotHelper.makeScreenshot();

        // Получение размера листа в подменю 'Приготовление пищи'
        startPage.getAppliancesLink().focusOnLink();
        startPage.getCookingLink().focusOnLink();
        actualCountMakeCooking = startPage.getSizeListCooking();

        // Перемещаем курсор на плиты и кликаем
        startPage.getAppliancesLink().focusOnLink();
        startPage.getStovesLink().focusOnLink();
        startPage.getStovesLink().click();
        ScreenshotHelper.makeScreenshot();

        return new StartPage(driver);
    }
}