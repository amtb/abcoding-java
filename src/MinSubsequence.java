import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinSubsequence {
  public List<Integer> minSubsequence(int[] nums) {
    List<Integer> sequence = new LinkedList<>();
    Arrays.sort(nums);

    int front = 0;
    for (int num : nums) front += num;

    int back = 0;
    int index = nums.length - 1;

    do {
      int num = nums[index];
      sequence.add(num);

      back += num;
      front -= num;
      index -= 1;
    } while (back <= front);

    return sequence;
  }
}
