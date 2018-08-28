import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    @Test
    public void test(){
        List<Allergen> allergens = Arrays.asList(Allergen.values());
        Collections.reverse(allergens);
        for (Allergen a : allergens){
            System.out.println(a);
        }
    }
}
