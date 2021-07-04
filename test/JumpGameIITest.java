import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGameIITest {

  @ParameterizedTest
  @MethodSource("cases")
  void jumpGameII(int[] nums, int expected) {
    JumpGameII solution = new JumpGameII();
    assertEquals(expected, solution.jump(nums));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
      Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
      Arguments.of(new int[]{1, 2}, 1),
      Arguments.of(new int[]{0}, 0),
      Arguments.of(new int[]{1,1,1,1}, 3),
      Arguments.of(new int[]{1,2,1,1,1}, 3),
      Arguments.of(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}, 3)
    );
  }
}
