import java.util.ArrayList;
import java.util.List;

class RaindropConverter {

    String convert(int number) {
        List<Integer> factors = getFactors(number);
        StringBuilder sb = new StringBuilder();

        if(factors.contains(3)) sb.append("Pling");
        if(factors.contains(5)) sb.append("Plang");
        if (factors.contains(7)) sb.append("Plong");

        if (sb.length() == 0) return Integer.toString(number);
        return sb.toString();
    }

    private List<Integer> getFactors(int number){
        List<Integer> listOfFactors = new ArrayList<>();
        for(int i=2; i <= number; i++){
            if(number % i == 0) {
                listOfFactors.add(i);
            }
        }
        return listOfFactors;
    }
}
