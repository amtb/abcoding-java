/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */
class ArraySign {
  public int arraySign(int[] nums) {
    int negatives = 0;
    for (int num : nums) {
      if (num < 0) negatives += 1;
      if (num == 0) return 0;
    }

    return negatives == 0 ? 1 : negatives % 2 == 0 ? 1 : -1;
  }
}
