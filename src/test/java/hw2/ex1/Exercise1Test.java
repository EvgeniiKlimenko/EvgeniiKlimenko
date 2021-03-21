package hw2.ex1;

import hw2.AbstractBaseTest;
import hw2.LoginUser;
import hw2.MenuList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class Exercise1Test extends AbstractBaseTest {

    @Test
    public void exerciseOneTest() {
        LoginUser loginUser = LoginUser.ROMAN;
        openHomePage();

        //3. Perform login
        login(loginUser);

        //4. User name
        assertUserName(loginUser);

        //5. 4 items on the header
        // "/html/body/header/div/nav/ul[1]/li[position()<5]/a"
        WebElement headerListTop = driver.findElement(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']"));
        ArrayList <WebElement> headerHorizontalList =
                (ArrayList<WebElement>) headerListTop.findElements(By.xpath("./li[position()<5]/a"));
        Assert.assertEquals(headerHorizontalList.size(), 4);
        for (WebElement el: headerHorizontalList) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText()));
        }

        //6. 4 images on the Index Page are displayed
        ArrayList <WebElement> imagesList =
                (ArrayList<WebElement>) driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(imagesList.size(), 4);
        for(WebElement el: imagesList) {
            Assert.assertTrue(el.isDisplayed());
        }

        //7. 4 texts under images
        ArrayList <WebElement> textsList =
                (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@class='col-sm-3']/div/span"));
        Assert.assertEquals(textsList.get(0).getText(),
                "To include good practices\nand ideas from successful\nEPAM project");
        Assert.assertEquals(textsList.get(1).getText(), "To be flexible and\ncustomizable");
        Assert.assertEquals(textsList.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(textsList.get(3).getText(),
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //8. iFrame with button
        WebElement frameWithButton = driver.findElement(By.id("frame"));
        Assert.assertTrue(frameWithButton.isDisplayed());

        //9. Switch to frame and check button
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.xpath("/html/body/span/div/div/input"));
        Assert.assertTrue(frameButton.isDisplayed());

        //10. Switch back
        driver.switchTo().defaultContent();

        //11. Sidebar menu
        ArrayList <WebElement> sidebarList =
                (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@class='sidebar-menu']/li[position()<6]/a/span"));
        Assert.assertEquals(sidebarList.size(), 5);
        for (WebElement el: sidebarList) {
            Assert.assertTrue(MenuList.HOME.checkIsContains(el.getText().toUpperCase()));
        }
        //12. Closing is in Abstract parent class
    }

}
