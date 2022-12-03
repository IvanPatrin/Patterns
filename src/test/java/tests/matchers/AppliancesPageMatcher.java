package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.AppliancesPage;

public class AppliancesPageMatcher {
    AppliancesPage page;
    private Logger logger = LogManager.getLogger(AppliancesPageMatcher.class);

    public AppliancesPageMatcher(AppliancesPage page) {
        this.page = page;
    }

    public void checkPageTitleText (String expected) {
        Assertions.assertEquals("Бытовая техника", page.getTextAppliances(), "Текст Бытовая техника не отображается");
        logger.info("Текст- 'Бытовая техника' отображен!");
    }
}