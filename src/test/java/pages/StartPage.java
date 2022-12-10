package pages;

import elements.Button;
import elements.Link;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class StartPage extends BasePage{
    private Logger logger = LogManager.getLogger(StartPage.class);
    private final String URL = "https://www.dns-shop.ru/";


    @FindBy(xpath = "//span[text()='Всё верно']")
    @CacheLookup
    private WebElement okay;

    @FindBy(xpath = "//a[text()='Бытовая техника']")
    @CacheLookup
    private WebElement linkAppliances;

    @FindBy(xpath = "//a[@class ='ui-link menu-desktop__first-level']")
    @CacheLookup
    private List<WebElement> listLinksAppliances;

    @FindBy(xpath = "(//a[text()='Приготовление напитков'])")
    @CacheLookup
    private WebElement linkCooking;

    @FindBy(xpath = "//a[@class ='ui-link menu-desktop__popup-link']")
    private List<WebElement> listCooking;

    @FindBy(xpath = "(//a[text() = 'Плиты и печи'])")
    @CacheLookup
    private WebElement linkStoves;

    @FindBy(xpath = "//a[text()='ПК, ноутбуки, периферия']")
    @CacheLookup
    private WebElement linkComputer;

    @FindBy(xpath = "//a[text() = 'Ноутбуки']")
    @CacheLookup
    private WebElement linkLaptops;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public Button getOkayButton() {
        return new Button(okay);
    }

    public Link getAppliancesLink() {
        return new Link(linkAppliances);
    }

    public List<String> getListLinksAppliances() {
        WaitHelper.visibilityOfElements(listLinksAppliances);
        List<String> listAppliancesText = new ArrayList<>();
        for(WebElement element : listLinksAppliances) {
            listAppliancesText.add(element.getText());
        }
        return listAppliancesText;
    }

    public Link getCookingLink() {
        WaitHelper.visibilityOfElement(linkCooking);
        return new Link(linkCooking);
    }

    public int getSizeListCooking() {
        WaitHelper.visibilityOfElements(listCooking);
        return listCooking.size();
    }

    public Link getStovesLink() {
        WaitHelper.visibilityOfElement(linkStoves);
        return new Link(linkStoves);
    }

    public Link getComputerLink() {
        WaitHelper.visibilityOfElement(linkComputer);
        return new Link(linkComputer);
    }

    public Link getLaptopsLink() {
        return new Link(linkLaptops);
    }
}