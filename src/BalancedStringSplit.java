/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class BalancedStringSplit {

  public int balancedStringSplit(String s) {
    int count = 0;
    int length = s.length();

    int start = 0;
    while (start < length) {
      count += 1;
      start = findIndexOfNextBalancedString(s, start, length);
    }

    return count;
  }

  /**
   * finds the next shortest balanced string
   */
  private int findIndexOfNextBalancedString(String s, int start, int end) {
    int countOfRs = 0;
    int countOfLs = 0;

    int index = start;

    do {
      if (s.charAt(index) == 'R') {
        countOfRs += 1;
      } else {
        countOfLs += 1;
      }
      index += 1;
    } while (index < end && countOfRs != countOfLs);

    return start + countOfRs + countOfLs;
  }
}
