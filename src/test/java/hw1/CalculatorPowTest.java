package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractCalculatorTest{

    @Test(dataProvider = "powDoubleDataSet", dataProviderClass = CalcDataProvider.class)
    public void powTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        Assert.assertEquals(actual, expected);
    }

}
