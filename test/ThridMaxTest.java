import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThridMaxTest {

  @ParameterizedTest
  @MethodSource("cases")
  void thridMax(int[] nums, int output) {
    ThridMax solution = new ThridMax();
    assertEquals(output, solution.thirdMax(nums));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{3, 2, 1}, 1),
      Arguments.of(new int[]{1, 2}, 2),
      Arguments.of(new int[]{2, 2, 3, 1}, 1)
    );
  }
}
