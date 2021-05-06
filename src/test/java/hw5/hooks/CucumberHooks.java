package hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverSingleton;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverSingleton.getDriver(); // initialize web driver
    }

    @After
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

}
