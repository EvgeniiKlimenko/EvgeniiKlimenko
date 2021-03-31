package hw3.ex2;

import hw3.AbstractBaseTest;
import pages.DifferentElementsPage;
import pages.IndexPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise2Test extends AbstractBaseTest {

    @Test
    public void exerciseTwoTest() {
        driver.get(URL);
        IndexPage indexPage = new IndexPage(driver);
        DifferentElementsPage difElPage = new DifferentElementsPage(driver);
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        indexPage.login(ROMAN_LOGIN, ROMAN_PASSWORD);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect(ROMAN_CORRECT_NAME));

        //5. Service -> Different Elements Page
        indexPage.goToDifferentElementsPage();
        Assert.assertEquals(driver.getTitle(), "Different Elements");

        //6. Select checkboxes
        difElPage.selectCheckBoxes();

        //7. Select radio button
        difElPage.selectRadioButton();

        //8. Select dropdown
        difElPage.selectFromDropdownMenu();

        //9. Check logs (Water, wind, selen, yellow)
        List<WebElement> logsList = difElPage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));

    }
}
