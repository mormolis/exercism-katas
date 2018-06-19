import java.util.*;

public class PangramChecker {

    public boolean isPangram(String input) {
        Set<String> letters = new HashSet<>();
        List<String> specialChars = Arrays.asList(" ",",",".","/","&","\"","1","2","3","4","5","6","7","8","9","0","_");

        String[] phrase =  input.toLowerCase().split("");
        Arrays.stream(phrase).forEach(letter->{if (!specialChars.contains(letter))letters.add(letter);});
        return letters.size() == 26;
    }

}
