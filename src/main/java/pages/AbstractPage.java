package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver myDriver;

    protected AbstractPage(WebDriver driver) {
        this.myDriver = driver;
    }

    public String getPageTitle() {
        return myDriver.getTitle();
    }

}
