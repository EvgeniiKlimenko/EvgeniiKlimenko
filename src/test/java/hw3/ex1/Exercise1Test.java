package hw3.ex1;

import hw3.AbstractBaseTest;
import hw3.pages.IndexPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Exercise1Test extends AbstractBaseTest {

    private ArrayList<String> menuList;

    @BeforeTest
    public void initialize() {
        menuList = new ArrayList<>(5);
        menuList.add("HOME");
        menuList.add("CONTACT FORM");
        menuList.add("SERVICE");
        menuList.add("METALS & COLORS");
        menuList.add("ELEMENTS PACKS");
    }

    @Test
    public void exerciseOneTest() {
        driver.get(URL);
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        indexPage.login(LOGIN, PASSWORD);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect("ROMAN IOVLEV"));

        //5. 4 items on the header
        Assert.assertEquals(indexPage.getHeaderHorizList().size(), 4);
        for (WebElement el: indexPage.getHeaderHorizList()) {
            Assert.assertTrue(menuList.contains(el.getText()));
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
            Assert.assertTrue(menuList.contains(el.getText().toUpperCase()));
        }

        //12. Closing is in Abstract parent class

    }

}
