package src.main.java.com.ddau;

import java.util.Scanner;

public class StringInput {
    private int stringLength;

    StringInput(Scanner scanner) {
        getStringInput(scanner);
    }

    private void getStringInput(Scanner scanner) {
        System.out.print("How many characters would you like the string to have?: ");
        stringLength = scanner.nextInt();
    }

    public int getStringLength() {
        return stringLength;
    }

}