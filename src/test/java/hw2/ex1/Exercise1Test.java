package hw2.ex1;

import hw2.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;


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
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        ArrayList <WebElement> toggleList =
                (ArrayList<WebElement>) driver.findElements(By.className("dropdown-toggle"));
        toggleList.get(1).click();
        WebElement loginElement = driver.findElement(By.id("name"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("login-button"));
        loginElement.sendKeys(LOGIN);
        passwordElement.sendKeys(PASSWORD);
        submitBtn.click();

        //4. User name
        WebElement userName = driver.findElement(By.id("user-name"));
        Assert.assertEquals(userName.getText(), "ROMAN IOVLEV");

        //5. 4 items on the header
        WebElement headerListTop = driver.findElement(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']"));
        ArrayList <WebElement> headerHorizontalList =
                (ArrayList<WebElement>) headerListTop.findElements(By.xpath("/html/body/header/div/nav/ul[1]/li[position()<5]/a"));
        Assert.assertEquals(headerHorizontalList.size(), 4);
        for (WebElement el: headerHorizontalList) {
            Assert.assertTrue(menuList.contains(el.getText()));
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
                (ArrayList<WebElement>) driver.findElements(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[position()<5]/div/span"));
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
        //  /html/body/div/div[1]/div/div[1]/div/div[1]/ul/li[1]/a/span
        //  /html/body/div/div[1]/div/div[1]/div/div[1]/ul/li[2]/a/span
        ArrayList <WebElement> sidebarList =
                (ArrayList<WebElement>) driver.findElements(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[1]/ul/li[position()<6]/a/span"));
        Assert.assertEquals(sidebarList.size(), 5);
        for (WebElement el: sidebarList) {
            Assert.assertTrue(menuList.contains(el.getText().toUpperCase()));
        }
        //12. Closing is in Abstract parent class
    }


}
