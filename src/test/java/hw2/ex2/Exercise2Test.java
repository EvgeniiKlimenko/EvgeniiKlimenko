package hw2.ex2;

import hw2.AbstractBaseTest;
import hw2.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise2Test extends AbstractBaseTest {

    @Test
    public void exerciseTwoTest() {
        openHomePage();

        //3. Perform login
        login(LoginUser.ROMAN);

        //4. User name
        assertUserName(LoginUser.ROMAN);

        //5. Service -> Different Elements Page
        WebElement headerListTop = driver.findElement(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']"));
        driver.findElement(By.xpath("//header/div/nav/ul[1]/li[3]")).click();
        WebElement diffElemsPageRefer = headerListTop.findElement(By.xpath("//li[3]/ul/li[8]/a"));
        diffElemsPageRefer.click();
        Assert.assertEquals(driver.getTitle(), DIFFERENT_ELEMENTS_TITLE);

        //6. Select checkboxes
        driver.findElement(By.xpath("//label[contains(. ,'Water')]/input")).click(); // Water
        driver.findElement(By.xpath("//label[contains(. ,'Wind')]/input")).click(); // Wind

        //7. Select radio button
        driver.findElement(By.xpath("//label[contains(. ,'Selen')]/input")).click(); // Selen

        //8. Select dropdown
        driver.findElement(By.xpath("//*[@class='colors']/select/option[4]")).click(); // Yellow

        //9. Check logs (Water, wind, selen, yellow)
        List<WebElement> logsList = driver.findElements(By.xpath("//*[@class='info-panel-section']/ul/li"));
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));
    }

}
