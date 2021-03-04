package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtrTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] longDataSet() {
        return new Object[][] {
                {30L, 28L, 2L},
                {10L, 40L, -30L},
                {-1L, -20L, 19L},
                {-21L, -20L, -1L},
                {13L, 2L, 11L}
        };
    }

    @Test(dataProvider = "longDataSet")
    public void subtrLongTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] doubleDataSet() {
        return new Object[][] {
                {-10.6, -10.9, 0.3},
                {50.1, 50.9, -0.8},
                {10.15015, 5.0115, 5.13865}
        };
    }

    @Test(dataProvider = "doubleDataSet")
    public void subtrDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, 0.00001);
    }
}
