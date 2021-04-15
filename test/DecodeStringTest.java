import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeStringTest {

  @ParameterizedTest
  @MethodSource("cases")
  void decodeString(String in, String out) {
    DecodeString solution = new DecodeString();
    assertEquals(out, solution.decodeString(in));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("abcd", "abcd"),
      Arguments.of("3[a]2[bc]", "aaabcbc"),
      Arguments.of("3[a2[c]]", "accaccacc"),
      Arguments.of("abc3[cd]xyz", "abccdcdcdxyz")
    );
  }
}
