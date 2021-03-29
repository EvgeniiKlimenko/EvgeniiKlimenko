package hw4.steps;

import hw2.MenuList;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Check 4 items on the header")
    public void checkHeaderItemsIsCorrect() {
        Assert.assertEquals(indexPage.getHeaderHorizList().size(), 4);
        for (WebElement el: indexPage.getHeaderHorizList()) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText()));
        }
    }

    @Step("Check 4 images on the Index Page are displayed")
    public void benefitImagesIsDisplayed() {
        Assert.assertEquals(indexPage.getBenefitImagesList().size(), 4);
        for(WebElement el: indexPage.getBenefitImagesList()) {
            Assert.assertTrue(el.isDisplayed());
        }
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

    @Step("Check iFrame with butten on index page is displayed")
    public void iFrameWithButtonIsDisplayed() {
        WebElement frameWithButton = indexPage.getIFrameByName("frame");
        Assert.assertTrue(frameWithButton.isDisplayed());
    }

    @Step("Button within the IFrame is displayed")
    public void buttonWithinIFrameIsDisplayed() {
        WebElement frameButton = indexPage.getButtonFromIFrame();
        Assert.assertTrue(frameButton.isDisplayed());
    }

    @Step("Sidebar menu contains correct names")
    public void sidebarMenuContainsCorrectNames() {
        List<WebElement> sidebarList = indexPage.getSideBarMenuList();
        Assert.assertEquals(sidebarList.size(), 5);
        for (WebElement el: sidebarList) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText().toUpperCase()));
        }
    }

    public void logListContainsSpecificLogs() {
        List<WebElement> logsList = difElPage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));
    }

}
