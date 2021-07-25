import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumNumberofArrowstoBurstBalloons {
  static class Balloon {
    int start, end;

    Balloon(int s, int e) {
      start = s;
      end = e;
    }
  }

  public int findMinArrowShots(int[][] points) {
    List<Balloon> balloons = new ArrayList<>();

    for (int[] point : points) {
      Balloon b = new Balloon(point[0], point[1]);
      balloons.add(b);
    }

    Collections.sort(balloons, Comparator.comparingInt(b -> b.end));

    int numberOfArrows = 1;
    int farthest = balloons.get(0).end;

    for (int i = 1; i < balloons.size(); i++) {
      Balloon balloon = balloons.get(i);

      if (balloon.start > farthest) {
        farthest = balloon.end;
        numberOfArrows += 1;
      }
    }


    return numberOfArrows;
  }
}
