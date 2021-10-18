package nl.maikel.nedap.matrix.service;

import nl.maikel.nedap.matrix.model.Matrix;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatrixService {

    /**
     * creeert een matrix op basis van een meegegeven aantal rijen en kolommen
     * @param rowCount
     * @param columnCount
     * @return
     */
    public Matrix createMatrix(int rowCount, int columnCount) {
        int[][] fields = new int[rowCount][columnCount];
        int currentNumber = 1;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                fields[i][j] = currentNumber++;
            }
        }
        System.out.printf("\nCreated matrix with %s rows and %s columns, resulting in a total of %s fields\n",
                rowCount, columnCount, rowCount*columnCount);

        return new Matrix(rowCount, columnCount, fields);
    }

    /**
     * navigeert een matrix in een spiraal vorm vanaf rij 1 kolom 1
     * @param matrix
     * @return
     */
    public List<Integer> navigateMatrixSpiralWise(Matrix matrix) {
        int rowCount = matrix.getRowCount();
        int columnCount = matrix.getColumnCount();
        int[][] fields = matrix.getFields();

        int iterator = 0;
        int startingRowIndex = 0;
        int startingColumnIndex = 0;

        List<Integer> numbersSpiralWise = new ArrayList<>();

        while (startingRowIndex < rowCount && startingColumnIndex < columnCount) {
            // Eerste rij
            for (iterator = startingColumnIndex; iterator < columnCount; ++iterator) {
                numbersSpiralWise.add(fields[startingRowIndex][iterator]);
            }
            startingRowIndex++;

            // Laatste kolom
            for (iterator = startingRowIndex; iterator < rowCount; ++iterator) {
                numbersSpiralWise.add(fields[iterator][columnCount - 1]);
            }
            columnCount--;

            // Laatste rij
            if (startingRowIndex < rowCount) {
                for (iterator = columnCount - 1; iterator >= startingColumnIndex; --iterator) {
                    numbersSpiralWise.add(fields[rowCount - 1][iterator]);
                }
                rowCount--;
            }

            // Eerste kolom
            if (startingColumnIndex < columnCount) {
                for (iterator = rowCount - 1; iterator >= startingRowIndex; --iterator) {
                    numbersSpiralWise.add(fields[iterator][startingColumnIndex]);
                }
                startingColumnIndex++;
            }
        }

        return numbersSpiralWise;
    }
}
