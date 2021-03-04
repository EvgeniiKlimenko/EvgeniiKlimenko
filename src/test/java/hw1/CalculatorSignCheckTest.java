package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSignCheckTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] signCheckDataSet() {
        return new Object[][] {
                {16L}, {10L}, {1L}
        };
    }

    @Test(dataProvider = "signCheckDataSet")
    public void isPositiveTest(long a) {
        boolean actual = calculator.isPositive(a);
        Assert.assertTrue(actual);
    }


    @Test(dataProvider = "signCheckDataSet")
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
