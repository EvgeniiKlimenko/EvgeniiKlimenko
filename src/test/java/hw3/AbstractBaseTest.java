package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

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
        driver = null;
    }

}
