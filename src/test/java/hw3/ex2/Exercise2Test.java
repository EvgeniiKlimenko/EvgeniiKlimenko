package hw3.ex2;

import hw2.LoginUser;
import hw3.AbstractBaseTest;
import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise2Test extends AbstractBaseTest {

    @Test
    public void exerciseTwoTest() {
        driver.get(URL);
        IndexPage indexPage = new IndexPage(driver);
        DifferentElementsPage difElPage = new DifferentElementsPage(driver);
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        indexPage.login(LoginUser.ROMAN);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect(LoginUser.ROMAN));

        //5. Service -> Different Elements Page
        indexPage.goToDifferentElementsPage();
        Assert.assertEquals(driver.getTitle(), "Different Elements");

        // How to handle with such elements like in 6-7-8 ???
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
