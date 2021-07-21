import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> numbers = new HashSet<>(nums.length);
    for (int number : nums) numbers.add(number);

    int max = 0;
    for (int number : numbers) {
      if (numbers.contains(number - 1) == false) {
        int length = 1;
        while (numbers.contains(number + 1)) {
          number += 1;
          length += 1;
        }

        max = Math.max(max, length);
      }
    }

    return max;
  }
}
