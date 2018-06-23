import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Matrix {

    private String matrixAsString;
    private List<List<Integer>> matrix;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        this.matrix = new ArrayList<>();
        createMatrix();
    }

    int[] getRow(int rowNumber) {
        List<Integer> toConvert = matrix.get(rowNumber);
        int[] toReturn = new int[toConvert.size()];
        for(int i = 0; i < toConvert.size(); i++) {
            toReturn[i] = toConvert.get(i);
        }
        return toReturn;
    }

    int[] getColumn(int columnNumber) {
        int size = matrix.size();
        int [] columnToReturn = new int[size];
        for (int row = 0; row < size; row++){
            columnToReturn[row] = matrix.get(row).get(columnNumber);
        }
        return columnToReturn;
    }

    int getRowsCount() {
        return matrix.size();
    }

    int getColumnsCount() {
        return matrix.get(0).size();
    }

    private void createMatrix(){
        String [] iMatrix = matrixAsString.split("\n");
        List<List<String>> tempMatrix = new ArrayList<>();

        for (int i = 0; i < iMatrix.length; i++){
            tempMatrix.add(Arrays.asList(iMatrix[i].split(" ")));
        }

        for(List<String> row : tempMatrix){
            List<Integer> matrixRow = new ArrayList<>();
            for(String string : row){
                matrixRow.add(numberFromString(string));
            }
            matrix.add(matrixRow);
        }

    }

    private int numberFromString(String string){
        return Integer.parseInt(string);
    }
}
//"1 2 3\n4 5 6\n7 8 9"