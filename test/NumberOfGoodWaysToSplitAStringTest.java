import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfGoodWaysToSplitAStringTest {
  @ParameterizedTest
  @MethodSource("cases")
  void numSplits(String s, int expected) {
    NumberOfGoodWaysToSplitAString solution = new NumberOfGoodWaysToSplitAString();
    assertEquals(expected, solution.numSplits(s));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("aacaba", 2),
      Arguments.of("abcd", 1),
      Arguments.of("aaaaa", 4),
      Arguments.of("acbadbaada", 2)
    );
  }
}
