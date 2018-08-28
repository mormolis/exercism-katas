import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding {


    public String encode(String string) {

        if (string.isEmpty()) return "";
        int counter, j;
        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < string.length() - 1; i++) {
            counter = 0;
            j = i + 1;
            while (j < string.length() && string.charAt(i) == string.charAt(j)) {
                counter++;
                j++;
            }
            if (counter > 0) {
                i += counter;
                encodedString.append(counter + 1);
            }
            encodedString.append(string.charAt(i - counter));
        }

        if (isLastCharachterNotAppended(string)) {
            encodedString.append(string.charAt(string.length() - 1));
        }
        return encodedString.toString();
    }

    private boolean isLastCharachterNotAppended(String string) {
        return string.charAt(string.length() - 1) != string.charAt(string.length() - 2);
    }

    public String decode(String string) {

        if (string.isEmpty()) return "";
        List<Digit> listOfStrings = splitString(string);
        StringBuilder decodedString = new StringBuilder();

        for (Digit digit : listOfStrings) {
            for (int i = 0; i < digit.times; i++) {
                decodedString.append(digit.charachter);
            }
        }
        return decodedString.toString();
    }

    private List<Digit> splitString(String string) {
        StringBuilder times, character;
        List<Digit> toReturn = new ArrayList<>();
        String numbers = "1234567890";
        for (int i = 0; i < string.length(); i++) {
            String currentCharacter = String.valueOf(string.charAt(i));
            times = new StringBuilder();
            character = new StringBuilder();
            while (numbers.contains(currentCharacter)) {
                times.append(currentCharacter);
                if (i < string.length() - 1) {
                    i++;
                }
                currentCharacter = String.valueOf(string.charAt(i));
            }
            character.append(String.valueOf(string.charAt(i)));
            if (times.length() == 0) times.append("1");
            toReturn.add(new Digit(Integer.valueOf(times.toString()), character.toString()));
        }
        return toReturn;
    }

}
