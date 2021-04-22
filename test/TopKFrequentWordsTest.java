import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentWordsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void topKFrequent(String[] words, int k, String[] output) {
    TopKFrequentWords solution = new TopKFrequentWords();
    assertArrayEquals(output, solution.topKFrequent(words, k).toArray());
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2, new String[]{"i", "love"}),
      Arguments.of(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4, new String[]{"the", "is", "sunny", "day"})
    );
  }
}
