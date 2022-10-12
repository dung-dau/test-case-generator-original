package src.main.java.com.ddau;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class IntegerParser implements Parsable {
    private Integer[] data;
    private Scanner scanner;
    private String output = "";

    IntegerParser(Scanner scanner, Integer[] data) {
        this.scanner = scanner;
        this.data = data;
        parse();
    }

    public void parse() {
        String choice;

        if (data.length == 1) {
            output += Integer.toString(data[0]);
        }

        choice = getFormatChoice();
        convertToCommaSeparatedList();

        if (choice.equals("a")) {
            output = addFormattingCharacters("{ ", " }");
        }
    }

    private String getFormatChoice() {
        String choice = "q";
        ArrayList<Map.Entry<String, String>> formats = new ArrayList<>();
        formats.add(new AbstractMap.SimpleImmutableEntry<String, String>("a", "Java Array"));
        formats.add(new AbstractMap.SimpleImmutableEntry<String, String>("c", "Comma Separated List"));

        while (search(formats, choice) < 0) {
            System.out.println(
                    "How would you like your data to be formatted?");
            for (int i = 0; i < formats.size(); i++) {
                System.out.println(formats.get(i).getKey() + ": " + formats.get(i).getValue());
            }
            System.out.print("Enter your option: ");
            choice = scanner.next().toLowerCase();
            System.out.println();
            validateChoice(formats, choice);
        }

        return choice;
    }

    private void validateChoice(ArrayList<Map.Entry<String, String>> formats, String choice) {
        int i = 0;
        if (search(formats, choice) < 0) {
            System.out.print(choice + " is not equal to ");
            for (i = 0; i < formats.size() - 1; i++) {
                System.out.print(formats.get(i).getKey().toUpperCase() + "/" + formats.get(i).getKey() + ", ");
            }
            System.out.println(formats.get(i).getKey().toUpperCase() + "/" + formats.get(i).getKey());

            System.out.println(
                    "Please enter either:");
            for (i = 0; i < formats.size(); i++) {
                System.out.println("\t" + formats.get(i).getKey().toUpperCase() + " or " + formats.get(i).getKey()
                        + " for a " + formats.get(i).getValue());
            }
            System.out.println();
        }
    }

    private int search(ArrayList<Map.Entry<String, String>> formats, String target) {
        int low = 0, high = formats.size() - 1;
        return binarySearch(formats, target, low, high);
    }

    private int binarySearch(ArrayList<Map.Entry<String, String>> formats, String target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (formats.get(mid).getKey().compareTo(target) == 0) {
            return mid;
        } else if (formats.get(mid).getKey().compareTo(target) > 0) {
            return binarySearch(formats, target, low, mid - 1);
        }
        return binarySearch(formats, target, mid + 1, high);
    }

    private void convertToCommaSeparatedList() {
        if (data.length < 2) {
            return;
        }

        for (int i = 0; i < data.length - 1; i++) {
            output += Integer.toString(data[i]) + ", ";
        }
        output += Integer.toString(data[data.length - 1]);
    }

    private String addFormattingCharacters(String firstFormattingCharacters, String secondFormattingCharacters) {
        return firstFormattingCharacters + output + secondFormattingCharacters;
    }

    public String getOutput() {
        return output;
    }
}
