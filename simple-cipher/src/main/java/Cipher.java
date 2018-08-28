import java.util.concurrent.ThreadLocalRandom;

public class Cipher {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private String KEY;
    private final int ALPHABET_LENGTH = 26;

    public Cipher() {
        this.KEY = generateRandomKey();
    }

    public Cipher(String customKey) {
        illegalArgumentExceptionCheck(customKey);
        this.KEY = customKey;
    }

    public String getKey() {
        return KEY;
    }

    public String encode(String wordToEncode) {
        int index;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordToEncode.length(); i++) {
            index = ALPHABET.indexOf(wordToEncode.charAt(i));
            index += keyDifference(i);
            word.append(ALPHABET.charAt(index % ALPHABET_LENGTH));
        }
        return word.toString();
    }

    public String decode(String wordToDecode) {
        int index;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordToDecode.length(); i++) {
            index = ALPHABET.indexOf(wordToDecode.charAt(i));
            index -= keyDifference(i);
            if (index < 0) index = index + ALPHABET_LENGTH;
            word.append(ALPHABET.charAt(index));
        }

        return word.toString();
    }

    private int keyDifference(int index) {
        char key = KEY.charAt(index % ALPHABET_LENGTH);
        return ALPHABET.indexOf(key);
    }

    private void illegalArgumentExceptionCheck(String encodingKey) {
        if (encodingKey.isEmpty()) throw new IllegalArgumentException("Cannot accept empty encoding key");
        for (int i = 0; i < encodingKey.length(); i++) {
            if (ALPHABET.indexOf(encodingKey.charAt(i)) < 0) {
                throw new IllegalArgumentException("Key should not contain any numbers");
            }
        }
    }

    private String generateRandomKey() {
        StringBuilder randomKey = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            randomKey.append(ALPHABET.charAt(ThreadLocalRandom.current().nextInt(0, ALPHABET_LENGTH)));
        }
        return randomKey.toString();
    }


}
