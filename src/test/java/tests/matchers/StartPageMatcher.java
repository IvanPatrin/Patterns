package tests.matchers;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.StartPage;

import java.util.Arrays;
import java.util.List;

public class StartPageMatcher {
    StartPage page;
    private Logger logger = LogManager.getLogger(StartPageMatcher.class);

    public StartPageMatcher(StartPage page) {
        this.page = page;
    }

    public void checkListLinksAppliances(List<String> expected, List<String> actual) {
        Assertions.assertEquals(expected, actual, "Ссылки (Техника для кухни, Техника для дома, Красота и здоровье) не отображаются!");
        logger.info("Ссылки (Техника для кухни, Техника для дома, Красота и здоровье) отображаются!");
    }

    public void checkSizeListCooking(int expected, int actual) {
        Assertions.assertTrue(actual>expected, "Количество ссылок в подменю 'Приготовление пищи' меньше или равно 5'");
        logger.info("Количество ссылок в подменю 'Приготовление пищи' больше 5");
    }

}
