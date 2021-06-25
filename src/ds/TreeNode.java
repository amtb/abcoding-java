package ds;

import java.util.Objects;

// Definition for a binary tree node.
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TreeNode treeNode = (TreeNode) o;

    if (val != treeNode.val) return false;
    if (!Objects.equals(left, treeNode.left)) return false;
    return Objects.equals(right, treeNode.right);
  }

  public int hashCode() {
    int result = val;
    result = 31 * result + Objects.hashCode(left);
    result = 31 * result + Objects.hashCode(right);
    return result;
  }
}
