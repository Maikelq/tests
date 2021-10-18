package nl.maikel.nedap.matrix;

import nl.maikel.nedap.matrix.model.Matrix;

public class MatrixTestObjects {

    public static final Matrix MATRIX_ONE_BY_SEVEN = new Matrix(1, 7, new int[][]
            {
                    {1, 2, 3, 4, 5, 6, 7}
            }
    );

    public static final Matrix MATRIX_TWO_BY_THREE = new Matrix(2, 3, new int[][]
            {
                    {1, 2, 3},
                    {4, 5, 6}
            }
    );

    public static final Matrix MATRIX_FIVE_BY_FIVE = new Matrix(5, 5, new int[][]
            {
                    {1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25}
            }
    );
}
