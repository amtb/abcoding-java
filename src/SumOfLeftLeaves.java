import ds.TreeNode;

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
  private int sum(TreeNode node, boolean isLeft) {
    if (node == null) return 0;

    if (node.left == null && node.right == null) {
      return isLeft ? node.val : 0;
    }
    return sum(node.left, true) + sum(node.right, false);
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    return sum(root.left, true) + sum(root.right, false);
  }
}
