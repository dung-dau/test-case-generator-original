package src.main.java.com.ddau;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Input {
    private String typeChoice = "q";
    private IntegerInput integerInput;
    private StringInput stringInput;
    ArrayList<Map.Entry<String, String>> formats;

    Input(Scanner scanner) {
        formats = new ArrayList<>();
        formats.add(new AbstractMap.SimpleImmutableEntry<String, String>("i", "integer"));
        formats.add(new AbstractMap.SimpleImmutableEntry<String, String>("s", "string"));
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
        do {
            System.out.println("What type of data would you like?: ");
            for (int i = 0; i < formats.size(); i++) {
                System.out.println("\t" + formats.get(i).getKey().toUpperCase() + " or " + formats.get(i).getKey()
                        + ": " + formats.get(i).getValue());
            }
            System.out.print("Enter your option: ");
            typeChoice = scanner.nextLine().toLowerCase();
            if (search(formats, typeChoice) < 0) {
                System.out.print(typeChoice + " is not equal to ");
                for (int i = 0; i < formats.size() - 1; i++) {
                    System.out.print(formats.get(i).getKey().toUpperCase() + "/" + formats.get(i).getKey() + ", ");
                }
                System.out.println(
                        formats.get(formats.size() - 1).getKey().toUpperCase() + "/"
                                + formats.get(formats.size() - 1).getKey());
            }
        } while (search(formats, typeChoice) < 0);
        System.out.println();
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
