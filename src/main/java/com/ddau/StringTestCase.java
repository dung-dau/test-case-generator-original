package src.main.java.com.ddau;

import java.util.Random;

public class StringTestCase {
    private String testValue;
    private int stringLength;

    StringTestCase(int stringLength) {
        testValue = "";
        this.stringLength = stringLength;
        generateTestCases();
    }

    private void generateTestCases() {
        Random r = new Random();
        for (int i = 0; i < stringLength; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            testValue += String.valueOf(c);
        }
    }

    public String getTestValue() {
        return testValue;
    }

}