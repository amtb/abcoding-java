import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidSquareTest {
  @ParameterizedTest
  @MethodSource("cases")
  void validSquare(int[] p1, int[] p2, int[] p3, int[] p4, boolean output) {
    ValidSquare solution = new ValidSquare();
    assertEquals(output, solution.validSquare(p1, p2, p3, p4));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(
        new int[]{0, 0},
        new int[]{1, 1},
        new int[]{1, 0},
        new int[]{0, 1}, true),
      Arguments.of(
        new int[]{0, 0},
        new int[]{1, 1},
        new int[]{1, 0},
        new int[]{0, 12}, false),
      Arguments.of(
        new int[]{1,0},
        new int[]{-1,0},
        new int[]{0,1},
        new int[]{0,-1}, true)
    );
  }
}

