import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PascalTriangleIITest {
  @ParameterizedTest
  @MethodSource("cases")
  void pascalTriangle(int rowIndex, int[] expected) {
    PascalTriangleII solution = new PascalTriangleII();
    assertArrayEquals(expected, solution.getRow(rowIndex).stream().mapToInt(Integer::intValue).toArray());
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(3, new int[]{1, 3, 3, 1}),
      Arguments.of(0, new int[]{1}),
      Arguments.of(1, new int[]{1, 1})
    );
  }
}
