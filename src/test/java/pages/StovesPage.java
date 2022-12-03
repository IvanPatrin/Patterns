package pages;

import elements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StovesPage extends BasePage{

    @FindBy(xpath = "//span[text() = 'Плиты электрические']")
    WebElement linkElectricStove;

    public StovesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link getLinkElectricStove() {
        return new Link(linkElectricStove);
    }
}