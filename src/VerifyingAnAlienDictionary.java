import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> charOrder = new HashMap<>();
    char[] chars = order.toCharArray();
    for (int i = 0; i < chars.length; i++) charOrder.put(chars[i], i);

    Comparator<String> comparator = new Comparator<String>() {
      public int compare(String o1, String o2) {
        int minLength = Math.min(o1.length(), o2.length());

        for (int i = 0; i < minLength; i++) {
          char c1 = o1.charAt(i);
          char c2 = o2.charAt(i);

          int rank1 = charOrder.get(c1);
          int rank2 = charOrder.get(c2);

          if (rank1 < rank2) return -1;
          if (rank1 > rank2) return +1;
        }

        return o1.length() - o2.length();
      }
    };

    for (int i = 1; i < words.length; i++) {
      if (comparator.compare(words[i - 1], words[i]) > 0) return false;
    }

    return true;
  }
}
