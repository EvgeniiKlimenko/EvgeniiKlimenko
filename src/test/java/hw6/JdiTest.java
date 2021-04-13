package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.entities.MetalsAndColorsFormTestData;
import hw6.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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

        JdiSite.jdiHomePage.login(User.ROMAN);

        String actualName = JdiSite.jdiHomePage.getUserName();
        Assert.assertTrue(actualName.equalsIgnoreCase(User.ROMAN.getFullName()),
                        String.format("Actual: %s, expected: %s", actualName, User.ROMAN.getFullName()));

        JdiSite.jdiHomePage.goToMetalsAndColorsPage();

        String actualTitle = JdiSite.jdiMetalsAndColorsPage.driver().getTitle(); // ??? jdiMetalsAndColorsPage.title isn't working
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, "Metal and Colors",
                    String.format("Actual: %s, expected: %s", actualTitle, "Metal and Colors"));

    }

    @Test(dataProvider = "testDataFromJson", dataProviderClass = JsonDataProvider.class)
    public void testSubmitMetalsAndColors(MetalsAndColorsFormTestData testData) {

        JdiSite.jdiMetalsAndColorsPage.submitTestDataToMetalsAndColorsForm(testData);

    }

}
