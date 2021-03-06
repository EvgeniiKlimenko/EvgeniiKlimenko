package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultypTest extends AbstractCalculatorTest {

    @Test(dataProvider = "multyLongDataSet", dataProviderClass = CalcDataProvider.class)
    public void multypLongTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "multyDoubleDataSet", dataProviderClass = CalcDataProvider.class)
    public void multypDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        Assert.assertNotEquals(actual, expected); // floor
    }

}
