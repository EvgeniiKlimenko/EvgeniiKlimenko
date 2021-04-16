package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.entities.MetalsAndColorsFormTestData;
import hw6.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class JdiTest {

    private final String EXPECTED_METALS_AND_COLORS_PAGE_TITLE = "Metal and Colors";

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

        JdiSite.jdiHomePage.login(User.ROMAN);

        String actualName = JdiSite.jdiHomePage.getUserName();
        Assert.assertTrue(actualName.equalsIgnoreCase(User.ROMAN.getFullName()));

        JdiSite.jdiHomePage.goToMetalsAndColorsPage();

        String actualTitle = JdiSite.jdiMetalsAndColorsPage.driver().getTitle(); // ??? jdiMetalsAndColorsPage.title doesn't work
        Assert.assertEquals(actualTitle, EXPECTED_METALS_AND_COLORS_PAGE_TITLE);
        JdiSite.jdiMetalsAndColorsPage.prepareMetalsAndColorsForm();

    }

    @Test(dataProvider = "testDataFromJson", dataProviderClass = JsonDataProvider.class)
    public void testSubmitMetalsAndColors(MetalsAndColorsFormTestData testData) {
        JdiSite.jdiMetalsAndColorsPage.submitTestDataToMetalsAndColorsForm(testData);
        List<String> resultsList = JdiSite.jdiMetalsAndColorsPage.getResultsInfo();
        String expectedSummary = testData.getSummaryAsString();

        Assert.assertTrue(resultsList.get(0).contains(expectedSummary));

        for (String element: testData.elements) {
            Assert.assertTrue(resultsList.get(1).contains(element));
        }

        Assert.assertTrue(resultsList.get(2).contains(testData.color));

        Assert.assertTrue(resultsList.get(3).contains(testData.metals));

        for(String veg: testData.vegetables) {
            Assert.assertTrue(resultsList.get(4).contains(veg));
        }
    }

}
