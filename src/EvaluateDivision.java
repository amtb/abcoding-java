import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {
  class Quotient {
    String numerator, denominator;
    double value;

    Quotient(String numerator, String denominator, double value) {
      this.numerator = numerator;
      this.denominator = denominator;
      this.value = value;
    }

    Quotient invert() {
      return new Quotient(denominator, numerator, 1 / value);
    }
  }

  class Graph {
    Map<String, List<Quotient>> equations;

    Graph() {
      equations = new HashMap();
    }

    void addQuotient(String v, Quotient q) {
      List<Quotient> quotients = equations.getOrDefault(v, new LinkedList());
      quotients.add(q);
      equations.put(v, quotients);
    }

    boolean hasVariable(String v) {
      return equations.containsKey(v);
    }

    List<Quotient> getQuotients(String v) {
      return equations.getOrDefault(v, new LinkedList());
    }
  }

  class DFS {
    Map<String, Double> quotients;

    DFS(Graph g, String s) {
      quotients = new HashMap();
      traverse(g, s, 1.0);
    }

    void traverse(Graph g, String s, double cq) {
      quotients.put(s, cq);

      for (Quotient q : g.getQuotients(s)) {
        String b = q.denominator;
        if (!quotients.containsKey(b)) {
          traverse(g, b, cq * q.value);
        }
      }
    }

    Double getQuotient(String t) {
      return quotients.getOrDefault(t, -1.0);
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    double[] results = new double[queries.size()];

    Graph g = new Graph();
    for (int i = 0; i < equations.size(); i++) {
      String a = equations.get(i).get(0);
      String b = equations.get(i).get(1);
      double w = values[i];

      Quotient e = new Quotient(a, b, w);
      g.addQuotient(a, e);
      g.addQuotient(b, e.invert());
    }

    Map<String, DFS> searches = new HashMap();
    for (int i = 0; i < queries.size(); i++) {
      String a = queries.get(i).get(0);
      String b = queries.get(i).get(1);

      double result = -1;
      if (g.hasVariable(a)) {
        DFS dfs = searches.getOrDefault(a, new DFS(g, a));
        searches.put(a, dfs);
        result = dfs.getQuotient(b);
      }

      results[i] = result;
    }

    return results;
  }
}
