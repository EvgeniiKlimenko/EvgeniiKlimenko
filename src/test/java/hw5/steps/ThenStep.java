package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ThenStep extends AbstractBaseStep {

    // for home page
    @Then("Page title should be {string}")
    public void homePageTitleShouldBeAsExpected(String expectedTitle) {
        Assert.assertEquals(indexPage.getPageTitle(), expectedTitle);
    }

    @Then("name of logged in user should be {string}")
    public void loggedUserShouldBeAsExpected(String expectedUserName) {
        Assert.assertTrue(indexPage.isLoggedUserCorrect(expectedUserName));
    }

    @Then("'Different elements' page should be opened with page title {string}")
    public void differentElemsPageTitleShouldBeAsExpected(String expectedTitle) {
        Assert.assertEquals(difElPage.getPageTitle(), expectedTitle);
    }

    @Then("Names of all selected elements should be in log's texts")
    public void namesOfSelectedElemsShouldBeInLogs() {
        List<WebElement> logsList = difElPage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));
    }

    // Vip: condition changed to true
    @Then("1 log row has {string} text in log section")
    public void oneRowShouldContainTextInLog(String expectedTextInLog) {
        List<WebElement> logsList = userTablePage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains(expectedTextInLog));
    }

    // I added assertion for title of the User Table page.
    @Then("{string} page should be opened")
    public void userTablePageTitleShouldBeAsExpected(String expectedTitle) {
        Assert.assertEquals(userTablePage.getPageTitle(), expectedTitle);
    }

    //Ex2
    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void typeDropdownsShouldBeDisplayedOnUserTable() {
        List<WebElement> userTableMain = userTablePage.getUserTableMain();
        for(WebElement el: userTableMain) {
            Assert.assertTrue(el.findElement(By.xpath("./td[2]")).isDisplayed()); // dropdown menu is second!
        }
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void userNameShouldBeDisplayedOnUserTable() {
        List<WebElement> userTableMain = userTablePage.getUserTableMain();
        for(WebElement el: userTableMain) {
            Assert.assertTrue(el.findElement(By.xpath("./td[3]/a")).isDisplayed()); // or maybe check text itself?
        }
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUserTable() {
        List<WebElement> userTableMain = userTablePage.getUserTableMain();
        for(WebElement el: userTableMain) {
            Assert.assertTrue(el.findElement(By.xpath("./td[4]/div/span")).isDisplayed()); // or maybe check text itself?
        }
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkBoxesShouldBeDisplayedOnUserTable() {
        List<WebElement> userTableMain = userTablePage.getUserTableMain();
        for(WebElement el: userTableMain) {
            Assert.assertTrue(el.findElement(By.xpath("./td[4]/div/input")).isDisplayed());
        }
    }

    @And("User table should contain following values:")
    public void tableShouldContainValues(DataTable dataTable) {
        List<WebElement> userTableMain = userTablePage.getUserTableMain();
        List <List<String>> data = dataTable.asLists(); // data.row.column
        int rowCounter = 1;
        for(WebElement el: userTableMain) {
            Assert.assertEquals(el.findElement(By.xpath("./td[1]")).getText(), data.get(rowCounter).get(0));
            Assert.assertEquals(el.findElement(By.xpath("./td[3]")).getText(), data.get(rowCounter).get(1));
            Assert.assertEquals(el.findElement(By.xpath("./td[4]/div/span")).getText().replace("\n", " "), data.get(rowCounter).get(2));
            rowCounter++;
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainTypesForUserRoman(DataTable dataTable) {
        WebElement romanRowFromTable = userTablePage.getUserTableMain().get(0);
        List<WebElement> optionsList = romanRowFromTable.findElements(By.xpath("./td[2]/select/option[position()<4]"));
        List <List<String>> data = dataTable.asLists(); // data.row.column
        Assert.assertEquals(optionsList.get(0).getText(), data.get(1).get(0));
        Assert.assertEquals(optionsList.get(1).getText(), data.get(2).get(0));
        Assert.assertEquals(optionsList.get(2).getText(), data.get(3).get(0));
    }

}
