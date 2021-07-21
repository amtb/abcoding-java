import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumPointsYouCanObtainfromCardsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void maxScore(int[] cards, int k, int expected) {
    MaximumPointsYouCanObtainfromCards solution = new MaximumPointsYouCanObtainfromCards();
    assertEquals(expected, solution.maxScore(cards, k));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 1}, 3, 12),
      Arguments.of(new int[]{2, 2, 2}, 2, 4),
      Arguments.of(new int[]{9, 7, 7, 9, 7, 7, 9}, 7, 55),
      Arguments.of(new int[]{1, 1000, 1}, 1, 1),
      Arguments.of(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3, 202),
      Arguments.of(new int[]{7, 10, 2, 9, 8}, 3, 25)
    );
  }
}
