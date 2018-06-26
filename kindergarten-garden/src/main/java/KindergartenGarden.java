import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

class KindergartenGarden {

    private String garden;
    private int FIRST_ROW = 0;
    private int SECOND_ROW = 1;

    private Map<String,List<Plant>> studentToPlant = new HashMap<>();
    private final String[] STUDENTS = {"Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"};

    KindergartenGarden(String garden) {
        this.garden = garden;
        gardenProccessor();
    }

    List<Plant> getPlantsOfStudent(String student) {
        return studentToPlant.get(student);
    }

    private void gardenProccessor(){
        String[] proccessedGarden = garden.split("\\n");
        if(proccessedGarden.length !=2) exit(1);
        populateFromFirstPlantRow(proccessedGarden[FIRST_ROW]);
        populateFromSecondPlantRow(proccessedGarden[SECOND_ROW]);

    }

    private void populateFromSecondPlantRow(String s) {
        List<Plant> tempList;
        int studentIndex = 0;
        for(int i = 0; i < s.length() - 1 ; i+=2){
            tempList = studentToPlant.get(STUDENTS[studentIndex]);
            tempList.add(Plant.getPlant(s.charAt(i)));
            tempList.add(Plant.getPlant(s.charAt(i+1)));
            studentIndex++;
        }
    }

    private void populateFromFirstPlantRow(String s) {
        List<Plant> tempList;
        int studentIndex = 0;
        for(int i = 0; i < s.length() - 1 ; i+=2){
            tempList = new ArrayList<>();
            tempList.add(Plant.getPlant(s.charAt(i)));
            tempList.add(Plant.getPlant(s.charAt(i+1)));
            studentToPlant.put(STUDENTS[studentIndex], tempList);
            studentIndex++;
        }
    }
}


