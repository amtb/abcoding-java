import java.util.Deque;
import java.util.LinkedList;

public class MinRemoveToMakeValid {
  static final char EMPTY = ' ';
  static final char OPENING = '(';
  static final char CLOSING = ')';

  private class Parenthesis {
    char v;
    int i;

    Parenthesis(char v, int i) {
      this.v = v;
      this.i = i;
    }
  }

  public String minRemoveToMakeValid(String s) {
    Deque<Parenthesis> stack = new LinkedList<>();

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == OPENING) {
        chars[i] = EMPTY;
        stack.addFirst(new Parenthesis(c, i));
      } else if (c == CLOSING) {
        Parenthesis top = stack.peekFirst();
        if (top != null && top.v == OPENING) {
          chars[top.i] = OPENING;
          stack.removeFirst();
        } else {
          chars[i] = EMPTY;
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (char c: chars) {
      if (c != EMPTY) result.append(c);
    }

    return result.toString();
  }
}
