import java.util.*;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] nums) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];

      if (i == 0 || num > list.get(list.size() - 1)) {
        list.add(num);
      } else {
        int j = Collections.binarySearch(list, num);
        j = j >= 0 ? j : Math.abs(j + 1);
        list.set(j, num);
      }
    }

    return list.size();
  }
}
