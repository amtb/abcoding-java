import ds.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest {
  // bottom up
  private TreeNode deleteNodes(TreeNode node, Set<Integer> toDelete, List<TreeNode> newRoots) {
    if (node == null) return null;

    node.left = deleteNodes(node.left, toDelete, newRoots);
    node.right = deleteNodes(node.right, toDelete, newRoots);

    if (toDelete.contains(node.val)) {
      if (node.left != null) newRoots.add(node.left);
      if (node.right != null) newRoots.add(node.right);
      return null;
    }

    return node;
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> toRemove = new HashSet<>();
    for (int td : to_delete) toRemove.add(td);

    List<TreeNode> roots = new ArrayList<>();
    root = deleteNodes(root, toRemove, roots);

    // check the last one
    if (root != null && !toRemove.contains(root.val)) {
      roots.add(root);
    }

    return roots;
  }
}
