import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BullsAndCowsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void getHint(String secret, String guess, String expected) {
    BullsAndCows solution = new BullsAndCows();
    assertEquals(expected, solution.getHint(secret, guess));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("1807", "7810", "1A3B"),
      Arguments.of("1123", "0111", "1A1B"),
      Arguments.of("1", "0", "0A0B"),
      Arguments.of("1", "1", "1A0B"),
      Arguments.of("011", "110", "1A2B"),
      Arguments.of("1122", "1222", "3A0B")
    );
  }
}
