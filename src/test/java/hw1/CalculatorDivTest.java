package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractCalculatorTest {

    @Test(dataProvider = "divLongDataSet", dataProviderClass = CalcDataProvider.class)
    public void divLongTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divZeroTest() {
        calculator.div(10L, 0L);
    } // agree, local variable is excess

    @Test(dataProvider = "divDoubleDataSet", dataProviderClass = CalcDataProvider.class)
    public void divDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

}
