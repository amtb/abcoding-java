import ds.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteNodesAndReturnForestTest {

  @ParameterizedTest
  @MethodSource("cases")
  void delNodes(TreeNode tree, int[] toDelete, List<TreeNode> expected) {
    DeleteNodesAndReturnForest solution = new DeleteNodesAndReturnForest();
    List<TreeNode> result = solution.delNodes(tree, toDelete);

    assertEquals(expected.size(), result.size());
    assertTrue(expected.containsAll(result));
    assertTrue(result.containsAll(expected));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(
        new TreeNode(
          1,
          new TreeNode(2, new TreeNode(4), new TreeNode(5)),
          new TreeNode(3, new TreeNode(6), new TreeNode(7))
        ),
        new int[]{3, 5},
        Arrays.asList(
          new TreeNode(1, new TreeNode(2, new TreeNode(4), null), null),
          new TreeNode(6),
          new TreeNode(7)
        )
      ),
      Arguments.of(
        new TreeNode(
          1,
          new TreeNode(2, null, new TreeNode(3)),
          new TreeNode(4)
        ),
        new int[]{3},
        Arrays.asList(
          new TreeNode(1, new TreeNode(2), new TreeNode(4))
        )
      )
    );
  }
}
