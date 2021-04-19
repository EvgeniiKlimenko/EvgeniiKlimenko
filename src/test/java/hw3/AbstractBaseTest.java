package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertiesHolder;

import java.time.Duration;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String ROMAN_LOGIN = PropertiesHolder.PROPS.getProperty("user.roman.login");
    protected final String ROMAN_PASSWORD = PropertiesHolder.PROPS.getProperty("user.roman.password");
    protected final String ROMAN_CORRECT_NAME = PropertiesHolder.PROPS.getProperty("user.roman.correctName");
    protected final String HOME_PAGE_TITLE_EXPECTED = "Home Page";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver = null;
    }

}
