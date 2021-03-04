package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] longDataSet() {
        return new Object[][] {
                {10L, 2L, 5L},
                {50L, 2L, 25L}, // expected exception
                {100L, -20L, -5L}
        };
    }

    @Test(dataProvider = "longDataSet")
    public void divLongTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divZeroTest() {
        long actual = calculator.div(10L, 0L);
    }

    @DataProvider
    public Object[][] doubleDataSet() {
        return new Object[][] {
                {-10.5, -2.5, 4.2},
                {50.5, 5.05, 10.0},
                {1.0, 0.5, 2.0}
        };
    }

    @Test(dataProvider = "doubleDataSet")
    public void divDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }
}
