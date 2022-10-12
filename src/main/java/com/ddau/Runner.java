package src.main.java.com.ddau;

import java.util.Scanner;

public class Runner {
    private Input input;
    private Scanner scanner;

    Runner() {
        scanner = new Scanner(System.in);
        input = new Input(scanner);
    }

    public void run() {
        if (input.getTypeChoice().equals("i")) {
            int minValue = input.getIntegerInput().getMinValue();
            int maxValue = input.getIntegerInput().getMaxValue();
            int numValues = input.getIntegerInput().getNumValues();

            IntegerTestCase integerTestCase = new IntegerTestCase(minValue, maxValue, numValues);
            IntegerParser integerParser = new IntegerParser(integerTestCase.getTestValues(),
                    input.getIntegerInput().getFormatChoice());

            System.out.println(integerParser.getOutput());
        } else if (input.getTypeChoice().equals("s")) {
            int stringLength = input.getStringInput().getStringLength();

            StringTestCase stringTestCase = new StringTestCase(stringLength);

            System.out.println(stringTestCase.getTestValue());
        }
    }

    public static void main(String[] args) {
        Runner main = new Runner();
        main.run();
    }
}