package hw2.ex2;

import hw2.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Exercise2Test extends AbstractBaseTest {

    @Test
    public void exerciseTwoTest() {
        driver.get(URL);
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        ArrayList<WebElement> toggleList =
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

        //5. Service -> Different Elements Page
        WebElement headerListTop = driver.findElement(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']"));
        driver.findElement(By.xpath("//header/div/nav/ul[1]/li[3]")).click();
        WebElement diffElemsPageRefer = headerListTop.findElement(By.xpath("//li[3]/ul/li[8]/a"));
        diffElemsPageRefer.click();
        Assert.assertEquals(driver.getTitle(), "Different Elements");

        //6. Select checkboxes
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]")).click();

        //7. Select radio button
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]")).click();

        //8. Select dropdown
        driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]")).click();

        //9. Check logs (Water, wind, selen, yellow)
        ArrayList<WebElement> logsList =
                (ArrayList<WebElement>) driver.findElements(By.xpath("/html/body/div/div[3]/div/div[1]/div/div[1]/section[1]/div[2]/div/ul/li"));
        System.out.println("-----> Logs list size " + logsList.size());
        Assert.assertTrue(logsList.get(0).getText().contains("Yellow"));
        Assert.assertTrue(logsList.get(1).getText().contains("Selen"));
        Assert.assertTrue(logsList.get(2).getText().contains("Wind"));
        Assert.assertTrue(logsList.get(3).getText().contains("Water"));
    }
}
