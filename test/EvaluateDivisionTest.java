import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EvaluateDivisionTest {

  @ParameterizedTest
  @MethodSource("cases")
  void calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries, double[] expected) {
    EvaluateDivision solution = new EvaluateDivision();
    assertArrayEquals(expected, solution.calcEquation(equations, values, queries));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(
        Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
        new double[] {2.0, 3.0},
        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")),
        new double[] {6.00000,0.50000,-1.00000,1.00000,-1.00000}
      ),
      Arguments.of(
        Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")),
        new double[] {1.5, 2.5, 5.0},
        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b"), Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc")),
        new double[] {3.75000, 0.40000,5.00000,0.20000}
      ),
      Arguments.of(
        Arrays.asList(Arrays.asList("a", "b")),
        new double[] {0.5},
        Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"), Arrays.asList("a", "c"), Arrays.asList("x", "y")),
        new double[] {0.50000,2.00000,-1.00000,-1.00000}
      )
    );
  }
}
