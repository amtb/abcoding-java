import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTest {
  @ParameterizedTest
  @MethodSource("cases")
  void reverseString(char[] s, char[] e) {
    ReverseString solution = new ReverseString();
    solution.reverseString(s);
    assertArrayEquals(e, s);
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new char[]{'h', 'e', 'l', 'l', 'o'},  new char[] {'o', 'l', 'l', 'e', 'h'}),
      Arguments.of(new char[]{'h', 'e', 'l', 'l'},  new char[] {'l', 'l', 'e', 'h'}),
      Arguments.of(new char[]{'h'},  new char[] {'h'}),
      Arguments.of(new char[]{},  new char[] {})
    );
  }
}
