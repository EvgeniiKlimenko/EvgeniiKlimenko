package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] doubleDataSet() {
        return new Object[][] {
                {16.0, 4.0},
                {100.0, 10.0},
                {2.0, 1.414},
                {4.0, 2.0},
                {25.0, 5.0},
                {36.0, 6.0},
        };
    }

    @Test(dataProvider = "doubleDataSet")
    public void sqrtTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        Assert.assertEquals(actual, expected , 0.001);
    }

}
