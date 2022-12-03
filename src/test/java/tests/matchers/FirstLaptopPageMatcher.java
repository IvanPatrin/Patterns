package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.FirstLaptopPage;

public class FirstLaptopPageMatcher {
    FirstLaptopPage page;
    private Logger logger = LogManager.getLogger(FirstLaptopPageMatcher.class);

    public FirstLaptopPageMatcher(FirstLaptopPage page) {
        this.page = page;
    }

    public void checkPageLaptopTitle(String expected) {
        Assertions.assertTrue(page.getPageTitle().contains(expected), "Заголовок не соответствует ожидаемому");
        logger.info("Заголовок страницы соответствует ожидаемому");
    }

    public void checkLaptopCharacteristicsTitle(String expected, String actual) {
        Assertions.assertTrue(actual.contains(expected), "Заголовок характеристик не содержит 'ASUS'");
        logger.info("Заголовок характеристик содержит 'ASUS'");
    }

    public void checkRamText(String expected, String actual) {
        Assertions.assertEquals(actual, expected, "В характеристиках значение 'Объем оперативной памяти' не равно 32 ГБ");
        logger.info("В характеристиках значение 'Объем оперативной памяти' равно 32 ГБ");
    }



}
