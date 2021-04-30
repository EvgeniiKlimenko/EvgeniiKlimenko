package hw4.steps;

import hw2.MenuList;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertionStep extends AbstractStep {

    private final int SIDEBAR_LIST_SIZE_EXPECTED = 5;
    private final int HEADER_HORIZON_LIST_SIZE_EXPECTED = 4;
    private final int BENEFIT_IMAGES_LIST_SIZE_EXPECTED = 4;

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Check 4 items on the header")
    public void checkHeaderItemsIsCorrect() {
        List<WebElement> horizontalList =  indexPage.getHeaderHorizList();
        Assert.assertEquals(horizontalList.size(), HEADER_HORIZON_LIST_SIZE_EXPECTED);
        SoftAssert softAssertion = new SoftAssert();
        for (WebElement el: horizontalList) {
            softAssertion.assertTrue(MenuList.HOME.checkIsContains(el.getText()));
        }
        softAssertion.assertAll();
    }

    @Step("Check 4 images on the Index Page are displayed")
    public void benefitImagesIsDisplayed() {
        List<WebElement> benefitImagesList = indexPage.getBenefitImagesList();
        Assert.assertEquals(benefitImagesList.size(), BENEFIT_IMAGES_LIST_SIZE_EXPECTED);
        SoftAssert softAssertion = new SoftAssert();
        for(WebElement el: benefitImagesList) {
            softAssertion.assertTrue(el.isDisplayed());
        }
        softAssertion.assertAll();
    }

    @Step("Check texts under images are correct")
    public void textsUnderImagesIsCorrect() {
        List<WebElement> benefitTextsList = indexPage.getBenefitTextsList();
        Assert.assertEquals(benefitTextsList.get(0).getText(),
                "To include good practices\nand ideas from successful\nEPAM project");
        Assert.assertEquals(benefitTextsList.get(1).getText(), "To be flexible and\ncustomizable");
        Assert.assertEquals(benefitTextsList.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(benefitTextsList.get(3).getText(),
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    }

    @Step("Check iFrame with button on index page is displayed")
    public void iFrameWithButtonIsDisplayed() {
        Assert.assertTrue(indexPage.getIFrameWithButton().isDisplayed());
    }

    @Step("Button within the IFrame is displayed")
    public void buttonWithinIFrameIsDisplayed() {
        Assert.assertTrue(indexPage.getButtonFromIFrame().isDisplayed());
    }

    @Step("Sidebar menu contains correct names")
    public void sidebarMenuContainsCorrectNames() {
        List<WebElement> sidebarList = indexPage.getSideBarMenuList();
        Assert.assertEquals(sidebarList.size(), SIDEBAR_LIST_SIZE_EXPECTED);
        SoftAssert softAssertion = new SoftAssert();
        for (WebElement el: sidebarList) {
            softAssertion.assertTrue(MenuList.HOME.checkIsContains(el.getText().toUpperCase()));
        }
        softAssertion.assertAll();
    }

    @Step("Logs list contains correct names")
    public void logListContainsSpecificLogs() {
        List<WebElement> logsList = difElPage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));
    }

}
