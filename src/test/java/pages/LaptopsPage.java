package pages;

import elements.*;
import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopsPage extends BasePage {

    @FindBy(xpath ="//header")
    @CacheLookup
    WebElement header;
    @FindBy(xpath = "//span[text() = 'ASUS  ']")
    @CacheLookup
    WebElement manufacturerCheckbox;
    @FindBy(xpath = "//span[text() = 'Объем оперативной памяти (ГБ)']")
    @CacheLookup
    WebElement ramChecklist;
    @FindBy(xpath = "//span[text() = '32 ГБ  ']")
    @CacheLookup
    WebElement ramCheckbox;
    @FindBy(xpath = "//button[text() = 'Применить']")
    @CacheLookup
    WebElement applyButton;
    @FindBy(xpath = "//span[text()='Сортировка:']")
    @CacheLookup
    WebElement sortSelectButton;
    @FindBy(xpath = "//span[text() = 'Сначала дорогие']")
    @CacheLookup
    WebElement sortRadioButton;
    @FindBy(xpath = "//a[@class = 'catalog-product__name ui-link ui-link_black'][1]")
    @CacheLookup
    WebElement firstLaptopLink;

    public LaptopsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Block getHeader() {
        return new Block(header);
    }

    public CheckBox getManufacturerCheckbox() {
        return new CheckBox(manufacturerCheckbox);
    }

    public Accordeon getRamChecklist() {
        return new Accordeon(ramChecklist);
    }

    public CheckBox getRamCheckbox() {
        return new CheckBox(ramCheckbox);
    }

    public Button getApplyButton() {
        return new Button(applyButton);
    }

    public Button getSortSelectButton() {
        return new Button(sortSelectButton);
    }

    public RadioButton getSortRadioButton() {
        return new RadioButton(sortRadioButton);
    }

    public Link getFirstLaptopLink() {
        WaitHelper.visibilityOfElement(firstLaptopLink);
        return new Link(firstLaptopLink);
    }
}
