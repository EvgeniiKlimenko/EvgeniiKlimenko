package utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            WebDriverManager.chromedriver().browserVersion("89.0.4389.90").setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }

}
