class NaturalNumber {

    private int number;
    public NaturalNumber(int number){
        if(number <= 0){
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        int sum = returnSumOfFactors();

        if(sum > number){
            return Classification.ABUNDANT;
        } else if (sum < number || number == 0){
            return Classification.DEFICIENT;
        }else {
            return Classification.PERFECT;
        }
    }

    private int returnSumOfFactors(){
        int sum = 0;
        for(int i = 1; i<number; i++){
            sum += number%i == 0 ? i : 0;
        }
        return sum;
    }
}
