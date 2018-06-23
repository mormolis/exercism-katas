import java.util.ArrayList;
import java.util.List;

class Sieve {
    private int [] numbers;
    private boolean [] marks;
    private int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
        if (maxPrime>=2){
            numbers = new int[maxPrime-1];
            marks = new boolean[maxPrime-1];
            populateArrays();
        }
    }

    private void populateArrays(){
        for (int i = 0; i<numbers.length; i++){
            numbers[i] = i+2;
            marks[i] = false;
        }
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        if(maxPrime<2) return primes;
        for (int i = 0; i < numbers.length; i++){
            if (marks[i] == true) continue;
            for(int j = i + numbers[i]; j < numbers.length; j+=numbers[i]){
                marks[j] = true;
            }
        }

        for(int i = 0; i<marks.length; i++){
            if (marks[i] == false){
                primes.add(numbers[i]);
            }
        }
        return primes;
    }
}
