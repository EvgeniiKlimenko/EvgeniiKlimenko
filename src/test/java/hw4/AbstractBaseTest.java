package hw4;

import utils.PropertiesHolder;
import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public abstract class AbstractBaseTest {

    protected final String  HOME_PAGE_TITLE_EXPECTED = "Home Page";
    protected final String ROMAN_LOGIN = PropertiesHolder.PROPS.getProperty("user.roman.login");
    protected final String ROMAN_PASSWORD = PropertiesHolder.PROPS.getProperty("user.roman.password");
    protected final String ROMAN_CORRECT_NAME = PropertiesHolder.PROPS.getProperty("user.roman.correctName");
    protected WebDriver driver;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    public void setUp(ITestContext context) {
        // .browserVersion("89.0.4389.82")
        // .browserVersion("89.0.4389.90")
        WebDriverManager.chromedriver().browserVersion("89.0.4389.90").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver = null;
    }

}
