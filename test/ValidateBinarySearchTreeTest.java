import ds.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateBinarySearchTreeTest {
  @ParameterizedTest
  @MethodSource("cases")
  void isValidBST(TreeNode tree, boolean expected) {
    ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
    assertEquals(expected, solution.isValidBST(tree));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new TreeNode(2, new TreeNode(1), new TreeNode(3)), true),
      Arguments.of(new TreeNode(5, new TreeNode(1), new TreeNode(4)), false)
    );
  }
}
