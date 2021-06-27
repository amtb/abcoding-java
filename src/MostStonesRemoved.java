import java.util.*;

/**
 * 947. Most Stones Removed with Same Row or
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * Creates a graph where stones on the same row / column have an "edge" between them
 * Computes the connected components using a DFS (all vertices from a CC can be removed except one)
 * The number of stones we can remove are the number of initial stones - the number of CCs
 */
public class MostStonesRemoved {
  static class Stone {
    int x, y;

    Stone(int[] stone) {
      x = stone[0];
      y = stone[1];
    }
  }

  static class Graph {
    public Map<Stone, Set<Stone>> stones;

    Graph() {
      stones = new HashMap<>();
    }

    public Set<Stone> adj(Stone s) {
      return stones.get(s);
    }

    public Set<Stone> getStones() {
      return stones.keySet();
    }

    public void addEdge(Stone s, Stone q) {
      add(s, q);
      add(q, s);
    }

    private void add(Stone s, Stone q) {
      if (s == null) return;
      Set<Stone> c = stones.getOrDefault(s, new HashSet<>());
      if (q != null) c.add(q);
      stones.put(s, c);
    }
  }

  static class ConnectedComponents {
    Set<Stone> visited;
    int count;

    ConnectedComponents(Graph g) {
      visited = new HashSet();

      for (Stone s : g.getStones()) {
        if (!visited.contains(s)) {
          traverse(g, s);
          count += 1;
        }
      }
    }

    void traverse(Graph g, Stone s) {
      visited.add(s);

      for (Stone q : g.adj(s)) {
        if (!visited.contains(q)) {
          traverse(g, q);
        }
      }
    }
  }

  public int removeStones(int[][] stones) {
    Map<Integer, List<Stone>> cols = new HashMap<>();
    Map<Integer, List<Stone>> rows = new HashMap<>();

    for (int[] stone : stones) {
      Stone s = new Stone(stone);

      addStone(cols, s, s.x);
      addStone(rows, s, s.y);
    }

    Graph graph = new Graph();
    connectStones(graph, cols.values());
    connectStones(graph, rows.values());

    return stones.length - new ConnectedComponents(graph).count;
  }

  private void addStone(Map<Integer, List<Stone>> map, Stone s, int coordinate) {
    List<Stone> list = map.getOrDefault(coordinate, new ArrayList<>());
    list.add(s);
    map.put(coordinate, list);
  }

  private void connectStones(Graph g, Iterable<List<Stone>> values) {
    for (List<Stone> list : values) {
      if (list.size() == 1) {
        g.addEdge(list.get(0), null);
      }
      for (int i = 1; i < list.size(); i++) {
        g.addEdge(list.get(i - 1), list.get(i));
      }
    }
  }
}
