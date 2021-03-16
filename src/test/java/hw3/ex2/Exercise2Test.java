package hw3.ex2;

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
        indexPage.login(LOGIN, PASSWORD);

        //4. User name
        Assert.assertTrue(indexPage.isLoggedUserCorrect("ROMAN IOVLEV"));

        //5. Service -> Different Elements Page
        indexPage.goToDifferentElementsPage();
        Assert.assertEquals(driver.getTitle(), "Different Elements");

        // How to handle with such elements like in 6-7-8 ???
        //6. Select checkboxes
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]")).click();

        //7. Select radio button
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]")).click();

        //8. Select dropdown
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]")).click();

        //9. Check logs (Water, wind, selen, yellow)
        List<WebElement> logsList = difElPage.getLogsList();
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));

    }
}
