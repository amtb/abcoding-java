import java.util.*;

/**
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {
  String[] words;
  Map<String, Integer> dictionary = new HashMap<>();
  Map<Integer, Integer> cache = new HashMap<>();

  public int longestStrChain(String[] words) {
    Arrays.sort(words, (a, b) -> b.length() - a.length());
    this.words = words;

    for (int i = 0; i < words.length; i++) {
      dictionary.put(words[i], i);
    }

    int longest = 0;
    for (int i = 0; i < words.length; i++) {
      longest = Math.max(longest, longestChain(i));
    }

    return longest;
  }

  private int longestChain(int start) {
    if (cache.containsKey(start)) {
      return cache.get(start);
    }

    int chainLength = 1;
    Set<Integer> predecessorIndexes = getPredecessorsIndexes(words[start]);
    for (Integer predecessorIndex : predecessorIndexes) {
      int subChainLength = longestChain(predecessorIndex);
      chainLength = Math.max(chainLength, 1 + subChainLength);
    }

    cache.put(start, chainLength);
    return chainLength;
  }

  private Set<Integer> getPredecessorsIndexes(String word) {
    Set<Integer> predecessors = new HashSet<>();
    for (int i = 0; i < word.length(); i++) {
      String predecessor = word.substring(0, i) + word.substring(i + 1);
      Integer predecessorIndex = dictionary.get(predecessor);
      if (predecessorIndex != null) {
        predecessors.add(predecessorIndex);
      }
    }

    return predecessors;
  }

  /**
   * Bottom-up approach
   */
  static class V2 {
    Map<String, Integer> cache = new HashMap<>();

    public int longestStrChain(String[] words) {
      Arrays.sort(words, Comparator.comparingInt(String::length));

      int longest = 0;
      for (int i = 0; i < words.length; i++) {
        longest = Math.max(longest, longestChain(words[i]));
      }

      return longest;
    }

    private int longestChain(String word) {
      int max = 1;
      for (int i = 0; i < word.length(); i++) {
        String predecessor = word.substring(0, i) + word.substring(i + 1);
        max = Math.max(max, 1 + cache.getOrDefault(predecessor, 0));
      }

      cache.put(word, max);
      return max;
    }
  }
}
