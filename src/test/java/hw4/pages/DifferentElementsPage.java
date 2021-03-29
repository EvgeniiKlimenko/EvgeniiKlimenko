package hw4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
//hw4
public class DifferentElementsPage extends AbstractPage{

    @FindBy(xpath = ("//*[@class='info-panel-section']/ul/li"))
    List<WebElement> logsList;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLogsList() { return logsList; }

    public void selectCheckBoxes() {
        myDriver.findElement(By.xpath("//label[contains(. ,'Water')]/input")).click(); // Water
        myDriver.findElement(By.xpath("//label[contains(. ,'Wind')]/input")).click(); // Wind
    }

    public void selectRadioButton() {
        myDriver.findElement(By.xpath("//label[contains(. ,'Selen')]/input")).click(); // Selen
    }

    public void selectFromDropdownMenu() {
        myDriver.findElement(By.xpath("//*[@class='colors']/select/option[4]")).click(); // Yellow
    }

}
