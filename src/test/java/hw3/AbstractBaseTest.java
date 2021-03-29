package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class AbstractBaseTest {

    protected Properties props;
    protected WebDriver driver;
    protected final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("89.0.4389.82").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));

        props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/userData.properties"));
        } catch (IOException badEvent) {
            System.out.println("Can't load properties file!");
            badEvent.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver = null;
    }

}
