import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/::
 */
public class InsertInterval {
  static class Interval {
    int start, end;

    Interval(int[] interval) {
      start = interval[0];
      end = interval[1];
    }

    void merge(Interval other) {
      start = Math.min(start, other.start);
      end = Math.max(end, other.end);
    }

    boolean overlaps(Interval other) {
      return start <= other.end && end >= other.start;
    }

    int[] toArray() {
      return new int[]{start, end};
    }

    public boolean isLessThan(Interval other) {
      return start < other.start;
    }
  }

  int getInsertionPoint(int searchResult) {
    if (searchResult < 0) {
      return Math.abs(searchResult + 1);
    }
    return searchResult;
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<Interval> list = new ArrayList<>(intervals.length);
    for (int[] interval : intervals) list.add(new Interval(interval));

    Interval toInsert = new Interval(newInterval);

    int left = getInsertionPoint(Collections.binarySearch(list, toInsert, (l, r) -> l.start - r.start));

    List<Interval> result = new ArrayList<>();
    if (list.size() == 0) {
      result.add(toInsert);
    } else {
      boolean inserted = false;

      for (int i = 0; i < list.size(); i++) {
        if (i < left - 1) {
          result.add(list.get(i));
        } else {
          boolean addInterval = true;
          Interval currentInterval = list.get(i);
          if (toInsert.overlaps(currentInterval)) {
            toInsert.merge(currentInterval);
            addInterval = false;
          }

          if (addInterval && currentInterval.isLessThan(toInsert)) {
            result.add(currentInterval);
          }

          if (!inserted) {
            result.add(toInsert);
            inserted = true;
          }

          if (addInterval && !currentInterval.isLessThan(toInsert)) {
            result.add(currentInterval);
          }

        }
      }
    }


    int[][] array = new int[result.size()][];
    for (int i = 0; i < array.length; i++) {
      array[i] = result.get(i).toArray();
    }

    return array;
  }
}
