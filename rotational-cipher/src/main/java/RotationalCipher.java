import java.util.Arrays;
import java.util.List;

class RotationalCipher {

    private int shiftKey;
    private final List<String> ALPHABET_LOW = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
    private final List<String> ALPHABET_CAP = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++){
            String letter = String.valueOf(data.charAt(i));
            if(isCapitalLetter(letter)){
                sb.append(ALPHABET_CAP.get( (ALPHABET_CAP.indexOf(letter) + shiftKey) % 26));
            } else if (isLowerCaseLetter(letter)) {
                sb.append(ALPHABET_LOW.get( (ALPHABET_LOW.indexOf(letter) + shiftKey) % 26));

            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    private boolean isLowerCaseLetter(String letter){
        return ALPHABET_LOW.contains(letter);
    }

    private boolean isCapitalLetter(String letter){
            return ALPHABET_CAP.contains(letter);
    }

}
