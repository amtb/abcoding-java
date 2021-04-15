import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
  static final String OPENING_BRACKET = "[";
  static final String CLOSING_BRACKET = "]";

  public String decodeString(String s) {
    String result = "";
    Deque<String> strings = new LinkedList<>();
    Deque<Integer> numbers = new LinkedList<>();

    String[] chars = s.split("");
    int i = 0;
    while (i < chars.length) {
      String character = chars[i];

      if (character.equals(OPENING_BRACKET)) {
        strings.addFirst(character);
        i += 1;
      } else if (character.equals(CLOSING_BRACKET)) {
        String substring = "";

        while (!strings.peekFirst().equals(OPENING_BRACKET)) {
          substring = strings.removeFirst() + substring;
        }
        // remove the opening bracket
        strings.removeFirst();

        int repetitions = numbers.removeFirst();
        substring = substring.repeat(repetitions);

        if (numbers.isEmpty()) {
          result += substring;
        } else {
          strings.addFirst(substring);
        }

        i += 1;

      } else if (isNumeric(character)) {
        String number = "";
        while (isNumeric(chars[i])) {
          number += chars[i];
          i += 1;
        }

        numbers.addFirst(Integer.valueOf(number));
      } else {
        if (numbers.isEmpty()) {
          result += character;
        } else {
          strings.addFirst(character);
        }
        i += 1;
      }
    }

    return result;
  }

  private boolean isNumeric(String character) {
    char c = character.charAt(0);
    return Character.isDigit(c);
  }
}

