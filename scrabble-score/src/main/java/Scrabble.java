import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private String word;
    private Map<String, Integer> letterScore;
    Scrabble(String word) {
        this.word = word;
        letterScore = new HashMap<>();
        populateLetterScore();
    }

    int getScore() {
        int score = 0;
        String[] words = word.split("");
        for(String letter : words){
            score += letterScore.get(letter.toUpperCase());
        }
        return score;
    }

    private void populateLetterScore(){
        letterScore.put("",0);
        letterScore.put("A",1);
        letterScore.put("E",1);
        letterScore.put("I",1);
        letterScore.put("O",1);
        letterScore.put("U",1);
        letterScore.put("L",1);
        letterScore.put("N",1);
        letterScore.put("R",1);
        letterScore.put("S",1);
        letterScore.put("T",1);
        letterScore.put("D",2);
        letterScore.put("G",2);
        letterScore.put("B",3);
        letterScore.put("C",3);
        letterScore.put("M",3);
        letterScore.put("P",3);
        letterScore.put("F",4);
        letterScore.put("H",4);
        letterScore.put("V",4);
        letterScore.put("W",4);
        letterScore.put("Y",4);
        letterScore.put("K",5);
        letterScore.put("J",8);
        letterScore.put("X",8);
        letterScore.put("Q",10);
        letterScore.put("Z",10);
    }

}
