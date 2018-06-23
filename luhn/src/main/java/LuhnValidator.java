class LuhnValidator {

    boolean isValid(String candidate) {
        int sum = 0;
        int digit;

        candidate = candidate.replaceAll(" ","");

        if(candidate.length() == 1) return false;

        for (int i = candidate.length(); i >= 1; i--){
            try {
                digit = stringToNumeral(candidate.substring(i-1, i));
            } catch (NumberFormatException e){
                return false;
            }

            if((candidate.length() - 1 - i) % 2 != 0 ){
                sum += digit;
            } else {
                sum += doubleNumber(digit);
            }
        }
        return sum % 10 == 0;
    }

    private int stringToNumeral(String substring){
        return Integer.parseInt(substring);
    }

    private int doubleNumber(int number){
        int doubling = number * 2;
        return doubling > 9 ? doubling - 9 : doubling;
    }
}
