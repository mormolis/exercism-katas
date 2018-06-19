import java.util.Arrays;

class Acronym {

    private String phrase;
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder sb = new StringBuilder();
        String [] phraseArray = phrase.split("[ -]");
        Arrays.stream(phraseArray).forEach(word->sb.append(word.charAt(0)));
        return sb.toString().toUpperCase();

    }

}
