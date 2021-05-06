package hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/hw5/cucumber_features")
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
