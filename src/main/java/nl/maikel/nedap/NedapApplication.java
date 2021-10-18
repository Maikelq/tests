package nl.maikel.nedap;

import nl.maikel.nedap.game.service.BoardService;
import nl.maikel.nedap.matrix.model.Matrix;
import nl.maikel.nedap.matrix.service.MatrixService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class NedapApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(NedapApplication.class, args);

//		 test 1
		BoardService boardService = new BoardService();
		boardService.startPlaying();
		while (!boardService.getBoard().isFinished()) {
			boardService.playNextTurn();
		}

		System.out.println("\n------------------------------------------\n");

		// test 2
		MatrixService matrixService = new MatrixService();
		Matrix matrix = matrixService.createMatrix(5, 5);
		List<Integer> numbersSpiralWise = matrixService.navigateMatrixSpiralWise(matrix);
		printNumbers(numbersSpiralWise);

		matrix = matrixService.createMatrix(3, 8);
		numbersSpiralWise = matrixService.navigateMatrixSpiralWise(matrix);
		printNumbers(numbersSpiralWise);

		matrix = matrixService.createMatrix(4, 2);
		numbersSpiralWise = matrixService.navigateMatrixSpiralWise(matrix);
		printNumbers(numbersSpiralWise);
	}

	private static void printNumbers(List<Integer> numbers) {
		List<String> numbersAsStrings = numbers.stream().map(Object::toString)
				.collect(Collectors.toList());
		System.out.println(String.join(", ", numbersAsStrings));
	}
}
