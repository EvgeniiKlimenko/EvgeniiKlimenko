package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractCalculatorTest{

    @DataProvider
    public Object[][] longDataSet() {
        return new Object[][] {
                {10L, 10L, 20L},
                {50L, 0L, 50L},
                {100L, -20L, 80L},
                {150L, -200L, -50L},
                {25L, -20L, 5L}
        };
    }

    @Test(dataProvider = "longDataSet")
    public void sumLongTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] doubleDataSet() {
        return new Object[][] {
                {-10.6, -10.9, -21.5},
                {50.001, 60.2, 110.201},
                {0.1, 0.011, 0.111}
        };
    }

    @Test(dataProvider = "doubleDataSet")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, 0.0001);
    }
}
