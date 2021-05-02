package hw4.ex3;

import hw2.MenuList;
import hw4.AbstractBaseTest;
import hw4.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IndexPage;
import java.util.List;

@Listeners({ScreenShotOnFailListener.class})
public class Exercise3Test extends AbstractBaseTest {
    private final String HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private final int SIDEBAR_LIST_SIZE_EXPECTED = 5;
    private final int HEADER_HORIZON_LIST_SIZE_EXPECTED = 4;
    private final int BENEFIT_IMAGES_LIST_SIZE_EXPECTED = 4;
    private final int SIDEBAR_LIST_SIZE_EXPECTED_WRONG = 20;    // to fail test, for screenshot making

    @Test(description = "Test screenshot on test fails.")
    public void exerciseThreeTest() {
        driver.get(HOME_PAGE_URL);
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE_EXPECTED);

        //3. Perform login
        indexPage.login(ROMAN_LOGIN, ROMAN_PASSWORD);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect(ROMAN_CORRECT_NAME));

        //5. 4 items on the header
        Assert.assertEquals(indexPage.getHeaderHorizList().size(), HEADER_HORIZON_LIST_SIZE_EXPECTED);
        for (WebElement el: indexPage.getHeaderHorizList()) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText()));
        }

        //6. 4 images on the Index Page are displayed
        Assert.assertEquals(indexPage.getBenefitImagesList().size(), BENEFIT_IMAGES_LIST_SIZE_EXPECTED);
        for(WebElement el: indexPage.getBenefitImagesList()) {
            Assert.assertTrue(el.isDisplayed());
        }

        //7. 4 texts under images
        List<WebElement> benefitTextsList = indexPage.getBenefitTextsList();
        Assert.assertEquals(benefitTextsList.get(0).getText(),
                "To include good practices\nand ideas from successful\nEPAM project");
        Assert.assertEquals(benefitTextsList.get(1).getText(), "To be flexible and\ncustomizable");
        Assert.assertEquals(benefitTextsList.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(benefitTextsList.get(3).getText(),
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //8. iFrame with button
        WebElement frameWithButton = indexPage.getIFrameWithButton();
        Assert.assertTrue(frameWithButton.isDisplayed());

        //9. Switch to frame and check button
        indexPage.goToIFrameByWebElement(frameWithButton);
        WebElement frameButton = indexPage.getButtonFromIFrame();
        Assert.assertTrue(frameButton.isDisplayed());

        //10. Switch back
        indexPage.switchToDefaultContent();

        //11. Sidebar menu
        List<WebElement> sidebarList = indexPage.getSideBarMenuList();
        Assert.assertEquals(sidebarList.size(), SIDEBAR_LIST_SIZE_EXPECTED_WRONG);  // test fails here!
        for (WebElement el: sidebarList) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText().toUpperCase()));
        }

        //12. Closing is in Abstract parent class

    }
}
