import ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
  private class SearchNode {
    TreeNode node;
    int height;

    SearchNode(TreeNode node, int height) {
      this.node = node;
      this.height = height;
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<SearchNode> queue = new LinkedList<>();
    queue.offer(new SearchNode(root, 1));

    while (!queue.isEmpty()) {
      SearchNode searchNode = queue.poll();
      TreeNode node = searchNode.node;
      if (node != null) {
        if (node.left == null && node.right == null) {
          return searchNode.height;
        }

        queue.offer(new SearchNode(node.right, 1 + searchNode.height ));
        queue.offer(new SearchNode(node.left, 1 + searchNode.height ));
      }
    }

    return -1;
  }
}
