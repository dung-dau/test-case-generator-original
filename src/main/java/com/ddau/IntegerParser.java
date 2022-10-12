package src.main.java.com.ddau;

public class IntegerParser {
    private String output;

    IntegerParser(Integer[] data, String formatChoice) {
        parseInput(data, formatChoice);
    }

    private void parseInput(Integer[] data, String formatChoice) {
        if (data.length == 1) {
            output += Integer.toString(data[0]);
        }

        convertToCommaSeparatedList(data);

        if (formatChoice.equals("a")) {
            output = addFormattingCharacters("{ ", " }");
        }
    }

    private void convertToCommaSeparatedList(Integer[] data) {
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
