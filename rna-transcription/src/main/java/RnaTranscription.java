import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        Map<String, String> conversionMap = mapInit();
        return Arrays.stream(dnaStrand.split(""))
                .map(letter ->(conversionMap.get(letter)))
                .collect(Collectors.joining());
    }



    private Map<String, String> mapInit(){
        Map<String, String> convertionMap = new HashMap<>();
        convertionMap.put("G", "C");
        convertionMap.put("C", "G");
        convertionMap.put("T", "A");
        convertionMap.put("A", "U");

        return convertionMap;
    }

}
