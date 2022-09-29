package src.main.java.com.ddau;

import java.lang.Math;

public class IntegerTestCase extends TestCase {
    private int minValue;
    private int maxValue;
    private Integer[] testValues;

    IntegerTestCase(int minValue, int maxValue, int numValues) {
        super(numValues);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.testValues = new Integer[numValues];
        generateTestCases();
    }

    @Override
    protected void generateTestCases() {
        for (int i = 0; i < numValues; i++) {
            int randNumber = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
            testValues[i] = Integer.valueOf(randNumber);
        }
    }

    public Integer[] getTestValues() {
        return testValues;
    }
}
