package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtrTest extends AbstractCalculatorTest {

    @Test(dataProvider = "subtrLongDataSet", dataProviderClass = CalcDataProvider.class)
    public void subtrLongTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "subtrDoubleDataSet", dataProviderClass = CalcDataProvider.class)
    public void subtrDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, 0.00001);
    }

}
