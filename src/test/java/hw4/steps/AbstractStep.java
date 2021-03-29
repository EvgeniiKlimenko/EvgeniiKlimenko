package hw4.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class AbstractStep {

    IndexPage indexPage;
    DifferentElementsPage difElPage;

    protected AbstractStep(WebDriver driver) {
        indexPage = new IndexPage(driver);
        difElPage = new DifferentElementsPage(driver);
    }

    @Step("Open home page")
    public void openIndexPage() {
        indexPage.openIndexPage();
    }

    @Step("Login into system with user")
    public void login(String login, String pass) {
        indexPage.login(login, pass);
    }

    @Step("Check the correct page title")
    public void pageTitleIsCorrect(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Check the correct user name after login")
    public void loggedInUserNameIsCorrect(String expectedUserName) {
        Assert.assertTrue(indexPage.isLoggedUserCorrect(expectedUserName));
    }

}
