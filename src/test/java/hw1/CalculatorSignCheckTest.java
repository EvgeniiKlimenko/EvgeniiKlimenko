package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSignCheckTest extends AbstractCalculatorTest {

    @Test(dataProvider = "signCheckDataSet", dataProviderClass = CalcDataProvider.class)
    public void isPositiveTest(long a) {
        boolean actual = calculator.isPositive(a);
        Assert.assertTrue(actual);
    }


    @Test(dataProvider = "signCheckDataSet", dataProviderClass = CalcDataProvider.class)
    public void isNegativeTest(long a) {
        boolean actual = calculator.isNegative(a);
        Assert.assertFalse(actual);
    }

    @Test
    public void zeroSignTest() {
        boolean actual = calculator.isPositive(0); // isn't zero counts as positive? why false?
        Assert.assertFalse(actual);
    }

}
