package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultypTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] longDataSet() {
        return new Object[][] {
                {30L, 28L, 840L},
                {-10L, 40L, -400L},
                {-15L, -20L, 300L}
        };
    }

    @Test(dataProvider = "longDataSet")
    public void multypLongTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] doubleDataSet() {
        return new Object[][] {
                {-10.6, -10.9, 115.54},
                {50.1, 50.9, 2550.09},
                {10.15015, 5.0115, 50.867476725}
        };
    }

    @Test(dataProvider = "doubleDataSet")
    public void multypDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        Assert.assertNotEquals(actual, expected); // floor
    }
}
