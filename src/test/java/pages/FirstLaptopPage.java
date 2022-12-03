package pages;

import elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstLaptopPage extends BasePage {

    @FindBy(xpath = "//button[text() = 'Развернуть все']")
    @CacheLookup
    WebElement characteristicsButton;
    @FindBy(xpath = "//div[@class = 'product-card-description__title']")
    @CacheLookup
    WebElement characteristicsTitle;
    @FindBy(xpath = "//div[text() = ' Объем оперативной памяти ']/following-sibling::div")
    @CacheLookup
    WebElement laptopRamText;

    public FirstLaptopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Button getCharacteristicsButton() {
        return new Button(characteristicsButton);
    }

    public String getCharacteristicsTitle() {
        return characteristicsTitle.getText();
    }

    public String getLaptopRamText() {
        return laptopRamText.getText();
    }
}