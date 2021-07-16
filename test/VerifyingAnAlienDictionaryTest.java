import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyingAnAlienDictionaryTest {
  @ParameterizedTest
  @MethodSource("cases")
  void isAlienSorted(String[] words, String order, boolean expected) {
    VerifyingAnAlienDictionary solution = new VerifyingAnAlienDictionary();
    assertEquals(expected, solution.isAlienSorted(words, order));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true),
      Arguments.of(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false),
      Arguments.of(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false)
      );
  }
}
