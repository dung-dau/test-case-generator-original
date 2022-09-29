package src.main.java.com.ddau;

public abstract class TestCase {
    protected final int numValues;

    protected TestCase(int newNumValues) {
        numValues = newNumValues;
    }

    protected abstract void generateTestCases();
}