package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DifferentElementsPage extends AbstractPage {
    private final String CHECKBOX_AND_RADIO_XPATH_BLANK = "//label[contains(. ,'%s')]/input";
    private final String COLORS_DROPDOWN_XPATH_BLANK = "//option[contains(. ,'%s')]";

    @FindBy(xpath = ("//*[@class='info-panel-section']/ul/li"))
    private List<WebElement> logsList;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public void selectElementsByXPath(String ... locators) {
        for(String locatorToClick: locators) {
            myDriver.findElement(By.xpath(locatorToClick)).click();
        }
    }

    public void selectCheckBoxes(String ... checkboxNames) {
        for(String checkbox: checkboxNames) {
            myDriver.findElement(By.xpath(String.format(CHECKBOX_AND_RADIO_XPATH_BLANK, checkbox))).click();
        }
    }

    public void selectRadioButton(String radioBoxName) {
        myDriver.findElement(By.xpath(String.format(CHECKBOX_AND_RADIO_XPATH_BLANK, radioBoxName))).click();
    }

    public void selectFromDropdownMenu(String option) {
        myDriver.findElement(By.xpath(String.format(COLORS_DROPDOWN_XPATH_BLANK, option))).click();
    }

}
