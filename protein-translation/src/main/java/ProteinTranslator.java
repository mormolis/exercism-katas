import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        final int sequenceLength = rnaSequence.length();
        Map<String, String> proteinMap = getProteinMap();
        List<String> proteins = new ArrayList<>();
        for (int i = 0; i < sequenceLength; i += 3) {
            if (sequenceLength + i >= 3) {
                if (proteinMap.get(rnaSequence.substring(i, i + 3)).equals("STOP")) {
                    break;
                }
                proteins.add(proteinMap.get(rnaSequence.substring(i, i + 3)));
            }
        }
        return proteins;
    }


    private Map<String, String> getProteinMap() {

        Map<String, String> proteinMap = new HashMap();

        proteinMap.put("AUG", "Methionine");
        proteinMap.put("UUU", "Phenylalanine");
        proteinMap.put("UUC", "Phenylalanine");
        proteinMap.put("UUA", "Leucine");
        proteinMap.put("UUG", "Leucine");
        proteinMap.put("UCU", "Serine");
        proteinMap.put("UCC", "Serine");
        proteinMap.put("UCA", "Serine");
        proteinMap.put("UCG", "Serine");
        proteinMap.put("UAU", "Tyrosine");
        proteinMap.put("UAC", "Tyrosine");
        proteinMap.put("UGU", "Cysteine");
        proteinMap.put("UGC", "Cysteine");
        proteinMap.put("UGG", "Tryptophan");
        proteinMap.put("UAA", "STOP");
        proteinMap.put("UAG", "STOP");
        proteinMap.put("UGA", "STOP");

        return proteinMap;
    }
}