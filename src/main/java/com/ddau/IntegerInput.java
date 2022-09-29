package src.main.java.com.ddau;

import java.util.Scanner;

public class IntegerInput {
    private int minValue;
    private int maxValue;
    private int numValues;

    IntegerInput(Scanner scanner) {
        getIntegerInput(scanner);
    }

    private void getIntegerInput(Scanner scanner) {
        System.out.print("How many values would you like? ");
        numValues = scanner.nextInt();
        System.out.print("What is the acceptable minimum value? ");
        minValue = scanner.nextInt();
        System.out.print("What is the acceptable maximum value? ");
        maxValue = scanner.nextInt();
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getNumValues() {
        return numValues;
    }
}
