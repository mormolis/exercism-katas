
class Matrix {

    private String matrixAsString;
    private int[][] matrix;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        createMatrix();
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        int [] columnToReturn = new int[matrix[columnNumber].length];
        for (int row = 0; row < matrix.length; row++){
            columnToReturn[row] = matrix[row][columnNumber];
        }
        return columnToReturn;
    }

    int getRowsCount() {
        return matrix.length;
    }

    int getColumnsCount() {
        return matrix[0].length;
    }

    private void createMatrix(){
        String [] iMatrix = matrixAsString.split("\n");
        String [][] tempMatrix = new String [iMatrix.length][iMatrix[0].split(" ").length];
        for (int i = 0; i < iMatrix.length; i++){
            tempMatrix[i] = iMatrix[i].split(" ");
        }

        this.matrix = new int [tempMatrix.length][tempMatrix[0].length];

        for (int i=0; i< tempMatrix.length; i++){
            for(int j=0; j< tempMatrix[0].length; j++){
                this.matrix[i][j] = numberFromString(tempMatrix[i][j]);
            }
        }
    }

    private int numberFromString(String string){
        return Integer.parseInt(string);
    }
}
//"1 2 3\n4 5 6\n7 8 9"