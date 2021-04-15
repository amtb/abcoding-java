import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToeplitzTest {

  @ParameterizedTest
  @MethodSource("cases")
  void isToeplitzMatrix(int[][] matrix, boolean output) {
    Toeplitz solution = new Toeplitz();
    assertEquals(output, solution.isToeplitzMatrix(matrix));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(
        new int[][]{
          {1, 2, 3, 4},
          {5, 1, 2, 3},
          {9, 5, 1, 2}
        }, true),
      Arguments.of(new int[][]{
        {1, 2},
        {2, 2}
      }, false)
    );
  }
}

