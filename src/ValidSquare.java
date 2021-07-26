import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 593. Valid Square
 * https://leetcode.com/problems/valid-square/
 */
public class ValidSquare {
  static class Point implements Comparable<Point> {
    int x, y;

    Point(int[] p) {
      x = p[0];
      y = p[1];
    }

    public int compareTo(Point o) {
      if (x == o.x) return y - o.y;
      return x - o.x;
    }

    public int squaredDistanceTo(Point o) {
      int diffX = x - o.x;
      int diffY = y - o.y;

      return diffX * diffX + diffY * diffY;
    }
  }

  public boolean validSquare(int[] pp1, int[] pp2, int[] pp3, int[] pp4) {
    List<Point> points = new ArrayList<>(4);
    points.add(new Point(pp1));
    points.add(new Point(pp2));
    points.add(new Point(pp3));
    points.add(new Point(pp4));

    Collections.sort(points);

    Point p1 = points.get(0);
    Point p2 = points.get(1);
    Point p3 = points.get(3);
    Point p4 = points.get(2);

    return p1.squaredDistanceTo(p2) > 0 && p1.squaredDistanceTo(p2) == p2.squaredDistanceTo(p3)
      && p2.squaredDistanceTo(p3) == p3.squaredDistanceTo(p4)
      && p3.squaredDistanceTo(p4) == p4.squaredDistanceTo(p1)
      && p1.squaredDistanceTo(p3) > 0 && p1.squaredDistanceTo(p3) == p2.squaredDistanceTo(p4);
  }
}
