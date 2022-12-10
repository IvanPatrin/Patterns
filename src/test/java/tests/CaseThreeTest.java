package tests;

import helpers.JavaScriptHelper;
import helpers.NavigationHelper;
import helpers.ScreenshotHelper;
import helpers.WaitHelper;
import listener.Selenium4Listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.CacheLookup;
import pages.FirstLaptopPage;
import pages.LaptopsPage;
import pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import tests.matchers.FirstLaptopPageMatcher;


public class CaseThreeTest extends BaseTest {
    String expectedNameTitle;

    private Logger logger = LogManager.getLogger(CaseThreeTest.class);

    @Test
    public void checkPageLaptopTitleTest() {

        // Arrange

        // Act
        FirstLaptopPage firstLaptopPage = getFirstLaptopPage();
        FirstLaptopPageMatcher firstLaptopPageMatcher = new FirstLaptopPageMatcher(firstLaptopPage);

        // Assert
        firstLaptopPageMatcher.checkPageLaptopTitle(expectedNameTitle);
    }

    @Test
    public void checkLaptopCharacteristicsTitleTest() {

        // Arrange
        String expectedCompany = "ASUS";

        // Act
        FirstLaptopPage firstLaptopPage = getFirstLaptopPage();
        FirstLaptopPageMatcher firstLaptopPageMatcher = new FirstLaptopPageMatcher(firstLaptopPage);

        // Assert
        firstLaptopPageMatcher.checkLaptopCharacteristicsTitle(expectedCompany,firstLaptopPage.getCharacteristicsTitle());
    }

    @Test
    public void checkRamTextTest() {

        // Arrange
        String expectedRam = "32 ГБ";

        // Act
        FirstLaptopPage firstLaptopPage = getFirstLaptopPage();
        FirstLaptopPageMatcher firstLaptopPageMatcher = new FirstLaptopPageMatcher(firstLaptopPage);

        // Assert
        firstLaptopPageMatcher.checkRamText(expectedRam, firstLaptopPage.getLaptopRamText());
    }


    public FirstLaptopPage getFirstLaptopPage() {
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        // Открытие сайта DNS
        StartPage startPage = new StartPage(eventFiringWebDriver);
        startPage.openPage();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Нажатие кнопки всё верно для дальнейшего тестирования
        startPage.getOkayButton().click();

        NavigationHelper.refresh();

        // Перемещение курсора на ПК, ноутбуки, периферия
        startPage.getComputerLink().focusOnLink();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Переход по ссылке Ноутбуки
        startPage.getLaptopsLink().click();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();
        LaptopsPage laptopsPage = new LaptopsPage(eventFiringWebDriver);

        // Скрыть блок страницы
        laptopsPage.getHeader().hide();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Выбор производителя - 'ASUS'
        JavaScriptHelper.scrollBy(0,600);
        laptopsPage.getManufacturerCheckbox().setChecked(true);

        // Выбор объёма оперативной памяти - '32 ГБ'
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.getRamChecklist().show();
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.getRamCheckbox().setChecked(true);

        // Нажатие на кнопку "Применить"
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.getApplyButton().click();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Применение сортировки - 'Сначала дорогие'
        laptopsPage.getSortSelectButton().click();
        laptopsPage.getSortRadioButton().setSelected(true);

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Сохранение названия ноутбука в переменную для дальнейшей проверки
        expectedNameTitle = laptopsPage.getFirstLaptopLink().getText();
        expectedNameTitle = expectedNameTitle.substring(0, expectedNameTitle.indexOf("["));

        // Нажатие на ссылку первого продукта в списке
        laptopsPage.getFirstLaptopLink().openInNewWindow();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Открытие списка характеристик
        FirstLaptopPage firstLaptopPage = new FirstLaptopPage(eventFiringWebDriver);
        JavaScriptHelper.scrollBy(0, 600);
        firstLaptopPage.getCharacteristicsButton().click();

        return new FirstLaptopPage(eventFiringWebDriver);
    }

}
