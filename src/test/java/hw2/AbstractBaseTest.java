package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected final String HOME_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String HOMEPAGE_TITLE = "Home Page";
    protected final String  DIFFERENT_ELEMENTS_TITLE = "Different Elements";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("89.0.4389.82").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    protected void openHomePage() {
        driver.get(HOME_URL);
        Assert.assertEquals(driver.getTitle(), HOMEPAGE_TITLE);
     }

    protected void login(LoginUser loginUser){
        ArrayList <WebElement> toggleList =
                (ArrayList<WebElement>) driver.findElements(By.className("dropdown-toggle"));
        toggleList.get(1).click();
        WebElement loginElement = driver.findElement(By.id("name"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("login-button"));
        loginElement.sendKeys(loginUser.getLogin());
        passwordElement.sendKeys(loginUser.getPassword());
        submitBtn.click();
     }

    protected void assertUserName(LoginUser loginUser) {
        WebElement userName = driver.findElement(By.id("user-name"));
        Assert.assertEquals(userName.getText(), loginUser.getCorrectName());
    }

}
