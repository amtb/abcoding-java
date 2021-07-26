import ds.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfLeftLeavesTest {
  @ParameterizedTest
  @MethodSource("cases")
  void sumOfLeftLeaves(TreeNode tree, int expected) {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    assertEquals(expected, solution.sumOfLeftLeaves(tree));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(
        new TreeNode(1),
        0
      ),
      Arguments.of(
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
        24
      )
    );
  }
}
