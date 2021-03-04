package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractCalculatorTest{

    @DataProvider
    public Object[][] doubleDataSet() {
        return new Object[][] {
                {-2.0, 4.0, 16.0},
                {10.5, 2.0, 110.25},
                {0.0, 2.0, 0.0}
        };
    }

    @Test(dataProvider = "doubleDataSet")
    public void powTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        Assert.assertEquals(actual, expected);
    }

}
