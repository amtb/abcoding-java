import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinRemoveToMakeValidTest {
  @ParameterizedTest
  @MethodSource("cases")
  void minRemoveToMakeValid(String in, String out) {
    MinRemoveToMakeValid solution = new MinRemoveToMakeValid();
    assertEquals(out, solution.minRemoveToMakeValid(in));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("lee(t(c)o)de)", "lee(t(c)o)de"),
      Arguments.of("a)b(c)d", "ab(c)d"),
      Arguments.of("))((", ""),
      Arguments.of("(a(b(c)d)", "a(b(c)d)")
    );
  }
}
