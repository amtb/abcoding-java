import ds.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {

  private class PathNode {
    PathNode parent;
    TreeNode node;
    int length;

    PathNode(PathNode p, TreeNode s) {
      parent = p;
      node = s;
      length = 1 + (p == null ? 0 : p.length);
    }
  }

  private class Lookup {
    PathNode path;
    TreeNode target;

    Lookup(TreeNode root, TreeNode target) {
      this.target = target;
      find(root, new PathNode(null, root));
    }

    private void find(TreeNode node, PathNode chain) {
      if (node != null) {
        if (node.val == target.val) {
          // target
          path = new PathNode(chain, node);
          return;
        } else {
          find(node.left, new PathNode(chain, node));
          find(node.right, new PathNode(chain, node));
        }
      }
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    PathNode pl = new Lookup(root, p).path;
    PathNode ql = new Lookup(root, q).path;

    PathNode shortest = pl.length < ql.length ? pl : ql;
    PathNode longest = shortest == pl ? ql : pl;

    Set<TreeNode> set = new HashSet<>();
    for (PathNode n = longest; n != null; n = n.parent) {
      set.add(n.node);
    }

    for (PathNode n = shortest; n != null; n = n.parent) {
      if (set.contains(n.node)) return n.node;
    }

    return null;
  }
}
