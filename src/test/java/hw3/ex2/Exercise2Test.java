package hw3.ex2;

import hw3.AbstractBaseTest;
import pages.DifferentElementsPage;
import pages.IndexPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise2Test extends AbstractBaseTest {
    private final String WATER_CHECKBOX_LOCATOR = "//label[contains(. ,'Water')]/input";
    private final String WIND_CHECKBOX_LOCATOR = "//label[contains(. ,'Wind')]/input";
    private final String SELEN_RADIO_BUTTON_LOCATOR = "//label[contains(. ,'Selen')]/input";
    private final String YELLOW_DROPDOWN_OPTION_LOCATOR = "//*[@class='colors']/select/option[4]";
    private final String DIFFERENT_ELEMENTS_PAGE_TITLE_EXPECTED = "Different Elements";

    @Test
    public void exerciseTwoTest() {
        driver.get(URL);
        IndexPage indexPage = new IndexPage(driver);
        DifferentElementsPage difElPage = new DifferentElementsPage(driver);
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE_EXPECTED);

        //3. Perform login
        indexPage.login(ROMAN_LOGIN, ROMAN_PASSWORD);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect(ROMAN_CORRECT_NAME));

        //5. Service -> Different Elements Page
        indexPage.goToDifferentElementsPage();
        Assert.assertEquals(driver.getTitle(), DIFFERENT_ELEMENTS_PAGE_TITLE_EXPECTED);

        //6. Select checkboxes
        //7. Select radio button
        //8. Select dropdown
        difElPage.selectElementsByXPath(WATER_CHECKBOX_LOCATOR, WIND_CHECKBOX_LOCATOR,
                                        SELEN_RADIO_BUTTON_LOCATOR, YELLOW_DROPDOWN_OPTION_LOCATOR);

        //9. Check logs (Water, wind, selen, yellow)
        List<WebElement> logsList = difElPage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));
    }

}
