import ds.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InOrderSucessorInBSTTest {
  @ParameterizedTest
  @MethodSource("cases")
  void inorderSuccessor(TreeNode tree, TreeNode target, Integer expected) {
    InOrderSuccessorInBST solution = new InOrderSuccessorInBST();
    TreeNode result = solution.inorderSuccessor(tree, target);
    assertEquals(expected, result == null ? null : result.val);
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(1), 2),
      Arguments.of(
        new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)),
        new TreeNode(6),
        null
      )
    );
  }
}
