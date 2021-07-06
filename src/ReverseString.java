/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
  private void reverse(int index, char[] s) {
    int half = s.length / 2;
    if (index < half) {
      char l = s[index];
      char r = s[s.length - 1 - index];

      s[index] = r;
      s[s.length - 1 - index] = l;

      reverse(index + 1, s);
    }
  }

  public void reverseString(char[] s) {
    reverse(0, s);
  }
}
