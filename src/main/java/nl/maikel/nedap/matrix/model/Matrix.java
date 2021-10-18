package nl.maikel.nedap.matrix.model;

public class Matrix {
    private final int rowCount;
    private final int columnCount;
    private final int[][] fields;

    public Matrix(int rowCount, int columnCount, int[][] fields) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.fields = fields;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int[][] getFields() {
        return fields;
    }
}
