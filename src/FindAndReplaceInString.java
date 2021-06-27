import java.util.Arrays;

/**
 * 833. Find And Replace in String
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
public class FindAndReplaceInString {
  static class Replacement {
    String source, target;
    int index;

    public Replacement(String source, String target, int index) {
      this.source = source;
      this.target = target;
      this.index = index;
    }

    public String toString() {
      return "{" +
        "source='" + source + '\'' +
        ", target='" + target + '\'' +
        ", index=" + index +
        '}';
    }
  }

  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    Replacement[] replacements = new Replacement[indices.length];
    for (int i = 0; i < indices.length; i++) {
      replacements[i] = new Replacement(sources[i], targets[i], indices[i]);
    }

    Arrays.sort(replacements, (l, r) -> l.index - r.index);

    int shift = 0;
    for (Replacement replacement : replacements) {

      boolean replaced = false;
      int index = -1;
      do {
        index = s.indexOf(replacement.source, index + 1);
        if (index >= 0 && index == shift + replacement.index) {
          shift += replacement.target.length() - replacement.source.length();
          s = s.substring(0, index) + replacement.target + s.substring(index + replacement.source.length());
          replaced = true;
        }
      } while (!replaced && index >= 0);
    }

    return s;
  }
}
