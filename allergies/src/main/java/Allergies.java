import java.util.*;

public class Allergies {

    private int allergyScore;
    private final List<Allergen> allergicTo = new ArrayList<>();
    private final List<Allergen> allergens = new ArrayList<>();

    public Allergies(int allergyScore) {
        this.allergyScore = allergyScore;

        this.allergens.addAll(Arrays.asList(Allergen.values()));
        Collections.reverse(allergens);

        populateAllergenList();
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergicTo.contains(allergen);
    }

    public List<Allergen> getList() {
        return allergicTo;
    }

    private void populateAllergenList() {

        Stack<Double> maximumScoreToCheck = findMaximumScoreToCheck();
        if (maximumScoreToCheck.empty()) return;

        ignoreAllergensNotOnTheList(maximumScoreToCheck);
        addAllergensToAllergicToList();

        Collections.reverse(allergicTo);
    }

    private void addAllergensToAllergicToList() {
        for (Allergen allergen : allergens) {
            if (allergen.getScore() <= allergyScore) {
                allergicTo.add(allergen);
                allergyScore -= allergen.getScore();
            }
        }
    }

    private void ignoreAllergensNotOnTheList(Stack<Double> maximumScoreToCheck) {
        maximumScoreToCheck.pop();
        while (allergyScore > 256) {
            allergyScore -= maximumScoreToCheck.pop();
        }
    }

    private Stack<Double> findMaximumScoreToCheck() {
        Stack<Double> maximumScoreToCheck = new Stack<>();
        int power = 0;
        while (Math.pow(2, power) <= allergyScore) {
            power++;
            maximumScoreToCheck.add(Math.pow(2, power));
        }

        return maximumScoreToCheck;
    }
}
