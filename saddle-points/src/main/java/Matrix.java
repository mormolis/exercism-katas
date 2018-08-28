import java.util.*;

class Matrix {

    private List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    private List<Integer> extractColumn(int columnIndex) {
        List<Integer> column = new ArrayList<>();
        values.stream().forEach(l -> column.add(l.get(columnIndex)));
        return column;
    }

    private List<Integer> findMaxesInRow(int rowIndex) {

        List<Integer> row = values.get(rowIndex);
        int max = Collections.max(row);

        List<Integer> maxIndexes = new ArrayList<>();
        for (int i = 0; i < row.size(); i++) {
            if (row.get(i).equals(max)) {
                maxIndexes.add(i);
            }
        }

        return maxIndexes;
    }


    Set<MatrixCoordinate> getSaddlePoints() {

        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        for (int i = 0; i < values.size(); i++) {
            List<Integer> maxOnRow = findMaxesInRow(i);
            for (int maxIndex : maxOnRow) {
                int max = values.get(i).get(maxIndex);
                List<Integer> column = extractColumn(maxIndex);
                if (Collections.min(column).equals(max)) {
                    saddlePoints.add(new MatrixCoordinate(i, maxIndex));
                }
            }
        }
        return saddlePoints;
    }

}
