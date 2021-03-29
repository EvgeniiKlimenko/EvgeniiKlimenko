package hw4;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class AbstractBaseTest {

    protected Properties props;
    protected WebDriver driver;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().browserVersion("89.0.4389.82").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/userData.properties"));
        } catch (IOException badEvent) {
            System.out.println("Can't load properties file!");
            badEvent.printStackTrace();
        }
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver = null;
    }

}
