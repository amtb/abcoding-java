import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 299. Bulls and Cows
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCows {
  static class BC {
    int bulls;
    int cows;

    BC(int b, int c) {
      this.bulls = b;
      this.cows = c;
    }
  }

  private BC getBullsAndCows(Set<Integer> left, Set<Integer> right) {
    int bulls = 0;
    int cows = Math.min(left.size(), right.size());

    for (Integer index : left) {
      if (right.contains(index)) {
        bulls += 1;
        cows -= 1;
      }
    }

    return new BC(bulls, cows);
  }

  public String getHint(String secret, String guess) {
    Map<Integer, Set<Integer>> secretMap = new HashMap<>();
    String[] secrets = secret.split("");
    for (int i = 0; i < secrets.length; i++) {
      int digit = Integer.parseInt(secrets[i]);
      Set<Integer> indexes = secretMap.getOrDefault(digit, new HashSet<>());
      indexes.add(i);
      secretMap.put(digit, indexes);
    }

    Map<Integer, Set<Integer>> guessMap = new HashMap<>();
    String[] guesses = guess.split("");
    for (int i = 0; i < guesses.length; i++) {
      int digit = Integer.parseInt(guesses[i]);
      Set<Integer> indexes = guessMap.getOrDefault(digit, new HashSet<>());
      indexes.add(i);
      guessMap.put(digit, indexes);
    }

    int bulls = 0, cows = 0;
    for (Map.Entry<Integer, Set<Integer>> entry : guessMap.entrySet()) {
      BC bsAndCs = getBullsAndCows(entry.getValue(), secretMap.getOrDefault(entry.getKey(), new HashSet<>()));
      bulls += bsAndCs.bulls;
      cows += bsAndCs.cows;
    }

    return String.format("%dA%dB", bulls, cows);
  }
}
