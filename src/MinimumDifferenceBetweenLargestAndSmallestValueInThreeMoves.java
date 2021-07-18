import java.util.Arrays;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
  public int minDifference(int[] nums) {
    if (nums.length <= 4) return 0;

    Arrays.sort(nums);
    return getMin(nums, 3);
  }

  private int getMin(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= k; i++) {
      min = Math.min(min, nums[nums.length - 1 - (k - i)] - nums[i]);
    }
    return min;
  }
}
