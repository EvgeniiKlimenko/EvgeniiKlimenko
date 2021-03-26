package hw3.ex1;

import hw2.LoginUser;
import hw2.MenuList;
import hw3.AbstractBaseTest;
import hw3.pages.IndexPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Exercise1Test extends AbstractBaseTest {

    @Test
    public void exerciseOneTest() {
        driver.get(URL);
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        indexPage.login(LoginUser.ROMAN);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect(LoginUser.ROMAN));

        //5. 4 items on the header
        Assert.assertEquals(indexPage.getHeaderHorizList().size(), 4);
        for (WebElement el: indexPage.getHeaderHorizList()) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText()));
        }

        //6. 4 images on the Index Page are displayed
        Assert.assertEquals(indexPage.getBenefitImagesList().size(), 4);
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
        WebElement frameWithButton = indexPage.getIFrameByName("frame");
        Assert.assertTrue(frameWithButton.isDisplayed());

        //9. Switch to frame and check button
        driver.switchTo().frame("frame");
        WebElement frameButton = indexPage.getButtonFromIFrame();
        Assert.assertTrue(frameButton.isDisplayed());

        //10. Switch back
        indexPage.switchToDefaultContent();

        //11. Sidebar menu
        List<WebElement> sidebarList = indexPage.getSideBarMenuList();
        Assert.assertEquals(sidebarList.size(), 5);
        for (WebElement el: sidebarList) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText().toUpperCase()));
        }

        //12. Closing is in Abstract parent class

    }

}
