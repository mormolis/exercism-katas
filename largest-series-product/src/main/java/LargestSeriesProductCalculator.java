class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        checkForExceptions(numberOfDigits);
        long max = Long.MIN_VALUE;
        long product = 1;
        for (int i=0; i <= inputNumber.length() - numberOfDigits; i++){
            for (int j = i; j < i + numberOfDigits; j++ ){
                product*=numberAt(j);
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


    private int numberAt(int position){
        return convertCharachter(String.valueOf(inputNumber.charAt(position)));
    }

    private int convertCharachter(String string){
        try {
            return Integer.parseInt(string);
        } catch (Exception e){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }
}
