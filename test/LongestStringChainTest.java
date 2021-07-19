import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestStringChainTest {
  @ParameterizedTest
  @MethodSource("cases")
  void longestStrChain(String[] words, int expected) {
    LongestStringChain solution = new LongestStringChain();
    assertEquals(expected, solution.longestStrChain(words));
  }

  @ParameterizedTest
  @MethodSource("cases")
  void longestStrChainV2(String[] words, int expected) {
    LongestStringChain.V2 solution = new LongestStringChain.V2();
    assertEquals(expected, solution.longestStrChain(words));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4),
      Arguments.of(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5),
      Arguments.of(new String[]{"abcd", "dbqca"}, 1),
      Arguments.of(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}, 7)
    );
  }

}

