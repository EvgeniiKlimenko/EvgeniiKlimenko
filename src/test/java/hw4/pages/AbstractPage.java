package hw4.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver myDriver;

    protected AbstractPage(WebDriver driver) {
        this.myDriver = driver;
    }

}
