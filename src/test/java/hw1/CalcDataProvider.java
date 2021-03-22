package hw1;

import org.testng.annotations.DataProvider;

public class CalcDataProvider {

    @DataProvider
    public Object[][] divLongDataSet() {
        return new Object[][] {
                {10L, 2L, 5L},
                {50L, 2L, 25L},
                {100L, -20L, -5L}
        };
    }

    @DataProvider
    public Object[][] divDoubleDataSet() {
        return new Object[][] {
                {-10.5, -2.5, 4.2},
                {50.5, 5.05, 10.0},
                {1.0, 0.5, 2.0}
        };
    }

    @DataProvider
    public Object[][] multyLongDataSet() {
        return new Object[][] {
                {30L, 28L, 840L},
                {-10L, 40L, -400L},
                {-15L, -20L, 300L}
        };
    }

    @DataProvider
    public Object[][] multyDoubleDataSet() {
        return new Object[][] {
                {-10.6, -10.9, 115.54},
                {50.1, 50.9, 2550.09},
                {10.15015, 5.0115, 50.867476725}
        };
    }

    @DataProvider
    public Object[][] powDoubleDataSet() {
        return new Object[][] {
                {-2.0, 4.0, 16.0},
                {10.5, 2.0, 110.25},
                {0.0, 2.0, 0.0}
        };
    }

    @DataProvider
    public Object[][] signCheckDataSet() {
        return new Object[][] {
                {16L}, {10L}, {1L}
        };
    }

    @DataProvider
    public Object[][] sqrtDoubleDataSet() {
        return new Object[][] {
                {16.0, 4.0},
                {100.0, 10.0},
                {2.0, 1.414},
                {4.0, 2.0},
                {25.0, 5.0},
                {36.0, 6.0},
        };
    }

    @DataProvider
    public Object[][] subtrLongDataSet() {
        return new Object[][] {
                {30L, 28L, 2L},
                {10L, 40L, -30L},
                {-1L, -20L, 19L},
                {-21L, -20L, -1L},
                {13L, 2L, 11L}
        };
    }

    @DataProvider
    public Object[][] subtrDoubleDataSet() {
        return new Object[][] {
                {-10.6, -10.9, 0.3},
                {50.1, 50.9, -0.8},
                {10.15015, 5.0115, 5.13865}
        };
    }

    @DataProvider
    public Object[][] sumLongDataSet() {
        return new Object[][] {
                {10L, 10L, 20L},
                {50L, 0L, 50L},
                {100L, -20L, 80L},
                {150L, -200L, -50L},
                {25L, -20L, 5L}
        };
    }

    @DataProvider
    public Object[][] sumDoubleDataSet() {
        return new Object[][] {
                {-10.6, -10.9, -21.5},
                {50.001, 60.2, 110.201},
                {0.1, 0.011, 0.111}
        };
    }

}
