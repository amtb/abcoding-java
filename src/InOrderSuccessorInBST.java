import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 285. Inorder Successor in BST
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InOrderSuccessorInBST {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p.right != null) {
      return findSmallest(p.right);
    }

    List<TreeNode> ancestors = new ArrayList<>();
    ancestors.add(null);
    TreeNode node = root;

    while (node != p && node != null) {
      ancestors.add(node);
      if (node.val > p.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    for (int i = ancestors.size() - 1; i >= 0; i--) {
      TreeNode ancestor = ancestors.get(i);
      if (ancestor != null && ancestor.val > p.val) return ancestor;
    }

    return null;
  }

  TreeNode findSmallest(TreeNode node) {
    if (node.left == null) return node;
    return findSmallest(node.left);
  }
}
