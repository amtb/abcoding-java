import java.util.HashMap;
import java.util.Map;

/**
 * 1525. Number of Good Ways to Split a String
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
public class NumberOfGoodWaysToSplitAString {
  public int numSplits(String s) {
    Map<Character, Integer> left, right;

    int leftKeys, rightKeys;

    left = new HashMap<>();
    right = new HashMap<>();

    left.put(s.charAt(0), 1);
    leftKeys = 1;

    rightKeys = 0;
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);

      Integer existing = right.get(c);
      if (existing == null) {
        existing = 0;
        rightKeys += 1;
      }
      right.put(c, existing + 1);
    }

    int goodSplits = leftKeys == rightKeys ? 1 : 0;

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);

      Integer leftCount = left.get(c);
      if (leftCount == null) {
        leftCount = 0;
        leftKeys += 1;
      }
      left.put(c, leftCount + 1);

      int rightCount = right.get(c);

      if (rightCount == 1) {
        right.remove(c);
        rightKeys -= 1;
      } else {
        right.put(c, rightCount - 1);
      }

      if (leftKeys == rightKeys) {
        goodSplits += 1;
      }
    }

    return goodSplits;
  }
}
