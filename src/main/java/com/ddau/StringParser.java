package src.main.java.com.ddau;

import java.util.Scanner;

public class StringParser {
    private String data;
    private Scanner scanner;
    String output;

    StringParser(Scanner scanner, String data) {
        this.scanner = scanner;
        this.data = data;
        output = "";
        parse();
    }

    private void parse() {
        String choice = "q";
        int n = data.length();

        System.out.print(
                "How would you like your data to be formatted? (R/r: Regular String, Q/q: String with double quotation marks, ");
        System.out.println("or C/c: As a character array?: ");
        choice = scanner.nextLine().toLowerCase();
        if (!choice.equals("r") && !choice.equals("q") && !choice.equals("c")) {
            System.out.println(choice + " is not equal to \"r\", \"q\", or \"c\"");
            System.out.print(
                    "Please enter either R or r for Regular String or Q or q for a String with double quotation marks, ");
            System.out.println("or C or c, for a character array");
        }
        if (choice.equals("q")) {
            output += "\"";
        }
        if (choice.equals("c")) {
            output += "{ ";
        }
        for (int i = 0; i < n - 1; i++) {
            if (choice.equals("c")) {
                output += "\'";
            }
            output += Integer.toString(data.charAt(i)) + ", ";
            if (choice.equals("c")) {
                output += "\'";
            }
        }
        output += Integer.toString(data.charAt(n - 1));
        if (choice.equals("q")) {
            output += "\"";
        }
        if (choice.equals("c")) {
            output += " }";
        }
    }

    public String getOutput() {
        return output;
    }
}