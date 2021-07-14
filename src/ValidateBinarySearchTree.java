import ds.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
  private boolean isValid(TreeNode node, long low, long high) {
    if (node == null) return true;

    if (low < node.val && node.val < high) {
      return isValid(node.left, low, node.val) &&
        isValid(node.right, node.val, high);
    }

    return false;
  }

  public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}
