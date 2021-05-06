package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class UserTablePage extends AbstractPage {
    private final String IVAN_CHECKBOX_ID = "ivan";

    @FindBy(xpath = ("//*[@id='user-table']/tbody/tr[position()<6]"))
    private List<WebElement> userTableMain;

    @FindBy(xpath = ("//*[@class='info-panel-section']/ul/li"))
    List<WebElement> logsList;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getUserTableMain() {
        return userTableMain;
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public void clickVipCheckBoxInTableForSergeyIvan() {
        myDriver.findElement(By.id(IVAN_CHECKBOX_ID)).click();
    }

}
