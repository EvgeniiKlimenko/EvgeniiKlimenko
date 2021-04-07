package hw5.steps;

import org.openqa.selenium.WebDriver;
import pages.DifferentElementsPage;
import pages.IndexPage;
import pages.UserTablePage;
import utils.PropertiesHolder;
import utils.WebDriverSingleton;

public abstract class AbstractBaseStep {

    IndexPage indexPage;
    DifferentElementsPage difElPage;
    UserTablePage userTablePage;
    protected final String ROMAN_LOGIN = PropertiesHolder.PROPS.getProperty("user.roman.login");
    protected final String ROMAN_PASSWORD = PropertiesHolder.PROPS.getProperty("user.roman.password");

    protected AbstractBaseStep() {
        WebDriver driver = WebDriverSingleton.getDriver();
        indexPage = new IndexPage(driver);
        difElPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }

}
