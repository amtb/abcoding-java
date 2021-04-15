import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedStringSplitTest {
  @ParameterizedTest
  @MethodSource("cases")
  void balancedStringSplit(String in, int out) {
    BalancedStringSplit solution = new BalancedStringSplit();
    assertEquals(out, solution.balancedStringSplit(in));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("RLRRLLRLRL", 4),
      Arguments.of("RLLLLRRRLR", 3),
      Arguments.of("LLLLRRRR", 1),
      Arguments.of("RLRRRLLRLL", 2)
    );
  }
}
