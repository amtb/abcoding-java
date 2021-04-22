/**
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class MaximumWealth {
  private int total(int[] account) {
    int total = 0;
    for (int v: account) total += v;
    return total;
  }

  public int maximumWealth(int[][] accounts) {
    int max = -1;
    for (int[] account: accounts) {
      int wealth = total(account);
      if (wealth > max) {
        max = wealth;
      }
    }

    return max;
  }
}
