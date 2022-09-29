package src.main.java.com.ddau;

import java.util.Scanner;

public class IntegerParser implements Parsable {
    private Integer[] data;
    private Scanner scanner;
    String output = "";

    IntegerParser(Scanner scanner, Integer[] data) {
        this.scanner = scanner;
        this.data = data;
        parse();
    }

    public void parse() {
        String choice = "q";
        int n = data.length;

        if (n == 1) {
            output += Integer.toString(data[0]);
        }

        while (!choice.equals("c") && !choice.equals("a")) {
            System.out.println(
                    "How would you like your data to be formatted? (A/a: Java Array, C/c: Comma Separated List)");
            choice = scanner.next().toLowerCase();
            if (!choice.equals("c") && !choice.equals("a")) {
                System.out.println(choice + " is not equal to \"c\" or \"j\"");
                System.out.println("Please enter either A or a for Java Array or C or c for a Comma Separated List");
            }
        }
        if (choice.equals("a")) {
            output += "{ ";
        }
        for (int i = 0; i < n - 1; i++) {
            output += Integer.toString(data[i]) + ", ";
        }
        output += Integer.toString(data[n - 1]);
        if (choice.equals("a")) {
            output += " }";
        }
    }

    public String getOutput() {
        return output;
    }
}
