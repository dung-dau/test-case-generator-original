package src.main.java.com.ddau;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class IntegerInput {
    private int minValue;
    private int maxValue;
    private int numValues;
    private String formatChoice;

    IntegerInput(Scanner scanner) {
        minValue = 1;
        maxValue = 0;
        numValues = 0;
        formatChoice = "";
        getIntegerInput(scanner);
    }

    private void getIntegerInput(Scanner scanner) {
        do {
            System.out.print("How many values would you like? ");
            numValues = scanner.nextInt();
            if (numValues < 1) {
                System.out.println("Please enter a value greater than 0");
            }
        } while (numValues < 1);

        System.out.println();

        do {
            System.out.print("What is the acceptable minimum value? ");
            minValue = scanner.nextInt();
            System.out.print("What is the acceptable maximum value? ");
            maxValue = scanner.nextInt();
            if (minValue > maxValue) {
                System.out.println("The minimum value can not be greater than the maximum value, please try again");
            }
        } while (minValue > maxValue);

        System.out.println();

        formatChoice = getFormatChoice(scanner);

        System.out.println();
    }

    private String getFormatChoice(Scanner scanner) {
        String choice = "q";
        ArrayList<Map.Entry<String, String>> formats = new ArrayList<>();
        formats.add(new AbstractMap.SimpleImmutableEntry<String, String>("a", "Java Array"));
        formats.add(new AbstractMap.SimpleImmutableEntry<String, String>("c", "Comma Separated List"));

        do {
            System.out.println(
                    "How would you like your data to be formatted?");
            for (int i = 0; i < formats.size(); i++) {
                System.out.println(formats.get(i).getKey().toUpperCase() + " or " + formats.get(i).getKey() + ": "
                        + formats.get(i).getValue());
            }
            System.out.print("Enter your option: ");
            choice = scanner.next().toLowerCase();
            validateChoice(formats, choice);
        } while (search(formats, choice) < 0);

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

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getNumValues() {
        return numValues;
    }

    public String getFormatChoice() {
        return formatChoice;
    }
}
