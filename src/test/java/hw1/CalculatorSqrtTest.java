package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @Test(dataProvider = "sqrtDoubleDataSet", dataProviderClass = CalcDataProvider.class)
    public void sqrtTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        Assert.assertEquals(actual, expected , 0.001);
    }

}
