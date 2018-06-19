import java.util.Arrays;

class ReverseString {

    String reverse(String inputString) {
        StringBuilder outputString = new StringBuilder(inputString);
        return outputString.reverse().toString();
    }
  
}