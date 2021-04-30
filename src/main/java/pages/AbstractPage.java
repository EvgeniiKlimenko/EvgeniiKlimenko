package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver myDriver;

    protected AbstractPage(WebDriver driver) {
        this.myDriver = driver;
        PageFactory.initElements(driver, this);
    }

}
