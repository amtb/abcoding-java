import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {
  class Edge {
    String a, b;
    double w;

    Edge(String a, String b, double w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }

    Edge revert() {
      return new Edge(b, a, 1 / w);
    }

    String other() {
      return b;
    }

    double weight() {
      return w;
    }
  }

  class Graph {
    Map<String, List<Edge>> adjacents;

    Graph() {
      adjacents = new HashMap();
    }

    void addEdge(String v, Edge e) {
      List<Edge> edges = adjacents.getOrDefault(v, new LinkedList());
      edges.add(e);
      adjacents.put(v, edges);
    }

    boolean hasVertex(String v) {
      return adjacents.containsKey(v);
    }

    List<Edge> edges(String v) {
      return adjacents.getOrDefault(v, new LinkedList());
    }
  }

  class DFS {
    Map<String, Double> weights;

    DFS(Graph g, String s) {
      weights = new HashMap();
      search(g, s, 1.0);
    }

    void search(Graph g, String s, double cw) {
      weights.put(s, cw);

      for (Edge e : g.edges(s)) {
        String b = e.other();
        if (!weights.containsKey(b)) {
          search(g, b, cw * e.weight());
        }
      }
    }

    Double getResult(String t) {
      return weights.getOrDefault(t, -1.0);
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    double[] results = new double[queries.size()];

    Graph g = new Graph();
    for (int i = 0; i < equations.size(); i++) {
      String a = equations.get(i).get(0);
      String b = equations.get(i).get(1);
      double w = values[i];

      Edge e = new Edge(a, b, w);
      g.addEdge(a, e);
      g.addEdge(b, e.revert());
    }

    Map<String, DFS> searches = new HashMap();
    for (int i = 0; i < queries.size(); i++) {
      String a = queries.get(i).get(0);
      String b = queries.get(i).get(1);

      double result = -1;
      if (g.hasVertex(a)) {
        DFS dfs = searches.getOrDefault(a, new DFS(g, a));
        searches.put(a, dfs);
        result = dfs.getResult(b);
      }

      results[i] = result;
    }

    return results;
  }
}
