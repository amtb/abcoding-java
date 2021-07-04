import java.util.HashMap;
import java.util.Map;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
  Map<Integer, Integer> cache;
  int[] nums;

  private Integer countJumps(int fromIndex) {
    if (cache.containsKey(fromIndex)) return cache.get(fromIndex);

    if (fromIndex == nums.length - 1) return 1;

    if (fromIndex >= nums.length) return null;
    if (nums[fromIndex] == 0) return null;


    int best = Integer.MAX_VALUE;
    boolean jumped = false;
    for (int i = 1; i <= nums[fromIndex]; i++) {
      Integer jumps = countJumps(fromIndex + i);
      cache.put(fromIndex + i, jumps);

      if (jumps != null) {
        best = Math.min(best, jumps);
        jumped = true;
      }
    }

    Integer result = jumped ? best + 1 : null;
    cache.put(fromIndex, result);
    return result;
  }

  public int jump(int[] nums) {
    if (nums.length == 1) return 0;

    this.nums = nums;
    this.cache = new HashMap<>();
    return countJumps(0) - 1;
  }
}
