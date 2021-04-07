package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = ("//*[@id='user-table']/tbody/tr[position()<6]"))
    private List<WebElement> userTableMain;

    @FindBy(xpath = ("//*[@class='info-panel-section']/ul/li"))
    List<WebElement> logsList;

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getUserTableMain() {
        return userTableMain;
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public void clickVipCheckBoxInTableForSergeyIvan() {
        myDriver.findElement(By.id("ivan")).click();
    }

}
