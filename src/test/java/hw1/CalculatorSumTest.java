package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractCalculatorTest{

    @Test(dataProvider = "sumLongDataSet", dataProviderClass = CalcDataProvider.class)
    public void sumLongTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sumDoubleDataSet", dataProviderClass = CalcDataProvider.class)
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, 0.0001);
    }
}
