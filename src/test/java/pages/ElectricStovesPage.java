package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectricStovesPage extends BasePage{

    @FindBy(className = "products-count")
    WebElement stoveCount;

    public ElectricStovesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getStoveCount() {
        String stoveCountText = stoveCount.getText();
        String[] stoveCountArray =stoveCountText.split("\\s");
        int count = Integer.parseInt(stoveCountArray[0].trim());
        return count;
    }
}
