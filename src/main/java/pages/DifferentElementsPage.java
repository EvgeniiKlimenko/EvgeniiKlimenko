package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(xpath = ("//*[@class='info-panel-section']/ul/li"))
    private List<WebElement> logsList;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public void selectElementsByXPath(String ... locators) {
        for(String locatorToClick: locators) {
            myDriver.findElement(By.xpath(locatorToClick)).click();
        }
    }

}
