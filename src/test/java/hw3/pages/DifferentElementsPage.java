package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {
    private WebDriver myDriver;

    @FindBy(xpath = ("/html/body/div/div[3]/div/div[1]/div/div[1]/section[1]/div[2]/div/ul/li"))
    List<WebElement> logsList;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        myDriver = driver;
    }

    public List<WebElement> getLogsList() { return logsList; }

}
