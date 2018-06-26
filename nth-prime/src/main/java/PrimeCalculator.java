class PrimeCalculator {

    int nth(int nth) {
        if (nth < 1){
            throw new IllegalArgumentException();
        }
        int primeCounter = 1;
        int lastPrime = 2;
        while(primeCounter < nth){
            int i = lastPrime;
            while(true){
                i++;
                if(isPrime(i)){
                    lastPrime = i;
                    primeCounter++;
                    break;
                }
            }
        }
        return lastPrime;
    }

    private boolean isPrime(int number){
        for (int i=2; i< number; i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
