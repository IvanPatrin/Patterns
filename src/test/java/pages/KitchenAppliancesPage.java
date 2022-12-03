package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KitchenAppliancesPage extends BasePage{
    private Logger logger = LogManager.getLogger(AppliancesPage.class);

    @FindBy(className = "subcategory__page-title")
    WebElement textKitchenAppliances;
    @FindBy(xpath = "//a[text()='Собрать свою кухню']")
    WebElement textMakeKitchen;
    @FindBy(className = "subcategory__title")
    List<WebElement> elementsKitchenAppliances;

    public KitchenAppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextKitchenAppliances() {
        return textKitchenAppliances.getText();
    }

    public String getTextMakeKitchen() {
        return textMakeKitchen.getText();
    }

    public void getElementsKitchenAppliances() {
        logger.info("Техника для кухни:");
        for (WebElement element : elementsKitchenAppliances) {
            logger.info(element.getText());
        }
    }

    public int getSizeKitchenAppliances() {
        return elementsKitchenAppliances.size();
    }
}