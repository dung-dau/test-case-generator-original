package src.main.java.com.ddau;

import java.util.Scanner;

public class Input {
    private String typeChoice = "q";
    private IntegerInput integerInput;
    private StringInput stringInput;

    Input(Scanner scanner) {
        getInput(scanner);
    }

    private void getInput(Scanner scanner) {
        getGenericInput(scanner);
        if (typeChoice.equals("i")) {
            integerInput = new IntegerInput(scanner);
        }
        if (typeChoice.equals("s")) {
            stringInput = new StringInput(scanner);
        }
    }

    private void getGenericInput(Scanner scanner) {
        while (!typeChoice.equals("i") && !typeChoice.equals("s")) {
            System.out.print("What type of data would you like? (I/i for integer and S/s for string/character): ");
            typeChoice = scanner.nextLine().toLowerCase();
            if (!typeChoice.equals("i") && !typeChoice.equals("s")) {
                System.out.println(typeChoice + " is not equal to \"i\", \"I\", \"s\", or \"S\"");
                System.out.println("Please enter either I or i for an integer or S or s for a string/character");
            }
        }
    }

    public IntegerInput getIntegerInput() {
        return integerInput;
    }

    public String getTypeChoice() {
        return typeChoice;
    }

    public StringInput getStringInput() {
        return stringInput;
    }

}
