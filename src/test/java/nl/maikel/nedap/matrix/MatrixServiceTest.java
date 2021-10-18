package nl.maikel.nedap.matrix;

import nl.maikel.nedap.matrix.model.Matrix;
import nl.maikel.nedap.matrix.service.MatrixService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MatrixServiceTest {

    @Autowired
    private MatrixService matrixService;

    @ParameterizedTest
    @MethodSource("getMatrixParamsAndExpectations")
    public void createMatrixTest(int rowCount, int columnCount, int expectedFieldsSize) {
        Matrix matrix = matrixService.createMatrix(rowCount, columnCount);

        List<Integer> fieldsAsList = convert2DArrayToList(matrix.getFields());

        assertEquals(expectedFieldsSize, fieldsAsList.size());
        assertTrue(fieldsAsList.containsAll(getExpectedIntegers(fieldsAsList.size())));
    }

    @ParameterizedTest
    @MethodSource("getMatrixAndExpectations")
    public void navigateMatrixSpiralWiseTest(Matrix matrix, List<Integer> expectedList) {
        List<Integer> result = matrixService.navigateMatrixSpiralWise(matrix);

        assertEquals(expectedList, result);
    }

    private static Stream<Arguments> getMatrixParamsAndExpectations() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(3, 8, 24),
                Arguments.of(2, 4, 8),
                Arguments.of(10, 10, 100)
        );
    }

    private static Stream<Arguments> getMatrixAndExpectations() {
        return Stream.of(
                Arguments.of(MatrixTestObjects.MATRIX_ONE_BY_SEVEN, List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(MatrixTestObjects.MATRIX_TWO_BY_THREE, List.of(1, 2, 3, 6, 5, 4)),
                Arguments.of(MatrixTestObjects.MATRIX_FIVE_BY_FIVE, List.of(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13))
        );
    }

    private List<Integer> getExpectedIntegers(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> convert2DArrayToList(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
    }
}
