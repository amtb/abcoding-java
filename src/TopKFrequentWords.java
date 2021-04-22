import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {
  static class WF implements Comparable<WF> {
    String word;
    Integer freq;

    WF(String w, int f) {
      this.word = w;
      this.freq = f;
    }

    public int compareTo(WF that) {
      int freqCompare = Integer.compare(this.freq, that.freq);
      if (freqCompare == 0) {
        // when the frequency is the same, store the words in a reverse order so we can stack them in the correct order
        return that.word.compareToIgnoreCase(this.word);
      }
      return freqCompare;
    }
  }

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> frequencies = new HashMap<>();

    for (String word : words) {
      Integer frequency = frequencies.get(word);
      if (frequency == null) {
        frequency = 0;
      }
      frequency += 1;
      frequencies.put(word, frequency);
    }

    PriorityQueue<WF> pq = new PriorityQueue<>();

    for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
      WF wf = new WF(entry.getKey(), entry.getValue());

      if (pq.size() < k) {
        pq.offer(wf);
      } else {
        WF min = pq.peek();
        if (wf.compareTo(min) >= 0) {
          pq.poll();
          pq.offer(wf);
        }
      }
    }

    LinkedList<String> result = new LinkedList<>();
    while (pq.size() > 0) result.addFirst(pq.poll().word);

    return result;
  }
}
