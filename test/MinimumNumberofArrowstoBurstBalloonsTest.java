import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumNumberofArrowstoBurstBalloonsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void findMinArrowShots(int[][] points, int expected) {
    MinimumNumberofArrowstoBurstBalloons solution = new MinimumNumberofArrowstoBurstBalloons();
    assertEquals(expected, solution.findMinArrowShots(points));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        {10, 16},{2, 8},{1, 6},{7, 12}
      },2),
      Arguments.of(new int[][]{
        {1, 2},{3, 4},{5, 6},{7, 8}
      },4),
      Arguments.of(new int[][]{
        {1,2},{2,3},{3,4},{4,5}
      }, 2)
    );
  }
}
