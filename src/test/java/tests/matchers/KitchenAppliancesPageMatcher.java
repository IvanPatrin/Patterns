package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.AppliancesPage;
import pages.KitchenAppliancesPage;

public class KitchenAppliancesPageMatcher {
    KitchenAppliancesPage page;
    private Logger logger = LogManager.getLogger(AppliancesPage.class);

    public KitchenAppliancesPageMatcher(KitchenAppliancesPage page) {
        this.page = page;
    }

    public void checkTextKitchenAppliances(String expected) {
        Assertions.assertEquals(expected,page.getTextKitchenAppliances(), "Текст техника для кухни не отображается");
        logger.info("Текст 'Техника для кухни' отображен!");
    }

    public void checkTextMakeKitchen(String expected) {
        Assertions.assertEquals(expected, page.getTextMakeKitchen(), "Текст Собрать свою кухню не отображается");
        logger.info("Ссылка 'Собрать свою кухню' отображена!");
    }

    public void checkSizeKitchenAppliances(int expected){
        Assertions.assertTrue(page.getSizeKitchenAppliances()>expected, "Количество категорий меньше 5");
        logger.info("Количество категорий больше 5");
    }

}
