import java.util.ArrayList;
import java.util.List;

class LargestSeriesProductCalculator {

    private String inputNumber;
    private List<Integer> numbers;

    LargestSeriesProductCalculator(String inputNumber) {
        this.numbers = new ArrayList<>();
        this.inputNumber = inputNumber;
        convertString();
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        checkForExceptions(numberOfDigits);
        long max = Long.MIN_VALUE;
        long product = 1;
        for (int i=0; i <= numbers.size() - numberOfDigits; i++){
            for (int j = i; j < i + numberOfDigits; j++ ){
                product*=numbers.get(j);
            }
            if (product > max) {
                max = product;
            }
            product = 1;
        }
        return max;
    }

    private void checkForExceptions(int numberOfDigits) {
        if (numberOfDigits>inputNumber.length()) throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        if (numberOfDigits < 0) throw new IllegalArgumentException("Series length must be non-negative.");
    }

    private void convertString(){
        for(int i = 0; i < inputNumber.length(); i++){
            numbers.add(convertCharachter(String.valueOf(inputNumber.charAt(i))));
        }
    }

    private int convertCharachter(String string){
        try {
            return Integer.parseInt(string);
        } catch (Exception e){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }
}
