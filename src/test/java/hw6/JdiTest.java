package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.entities.MetalsAndColors;
import hw6.entities.User;
import hw6.pages.JdiPages;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void testGoToMetalsAndColorPage() {
        JdiSite.jdiHomePage.open();
        JdiSite.jdiHomePage.checkOpened();
        JdiSite.jdiHomePage.login(User.ROMAN);
        JdiSite.jdiHomePage.userName.is().text(User.ROMAN.getFullName());
        JdiSite.goToPage(JdiPages.METALS_AND_COLORS_PAGE);
        JdiSite.jdiMetalsAndColorsPage.checkOpened();
        JdiSite.jdiMetalsAndColorsPage.prepareMetalsAndColorsForm();
    }

    @Test(dataProvider = "testDataFromJson", dataProviderClass = JsonDataProvider.class,
            dependsOnMethods = "testGoToMetalsAndColorPage")
    public void testSubmitMetalsAndColors(MetalsAndColors metalsAndColors) {
        JdiSite.jdiMetalsAndColorsPage.submitMetalsAndColorsForm(metalsAndColors);
        assertMetalsAndColorsSubmitResults(metalsAndColors, JdiSite.jdiMetalsAndColorsPage.getResultsInfo());
    }

    private void assertMetalsAndColorsSubmitResults(MetalsAndColors metalsAndColors, List<String> resultsList) {
        Assert.assertTrue(resultsList.get(0).contains(metalsAndColors.getSummaryAsString()));

        for (String element: metalsAndColors.elements) {
            Assert.assertTrue(resultsList.get(1).contains(element));
        }

        Assert.assertTrue(resultsList.get(2).contains(metalsAndColors.color));
        Assert.assertTrue(resultsList.get(3).contains(metalsAndColors.metals));

        for(String veg: metalsAndColors.vegetables) {
            Assert.assertTrue(resultsList.get(4).contains(veg));
        }
    }

}
