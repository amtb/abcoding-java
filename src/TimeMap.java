import java.util.*;

/**
 * 981. Time Based Key-Value Store
 * https://leetcode.com/problems/time-based-key-value-store/
 */
class TimeMap {
  static class Item implements Comparable<Item> {
    int timestamp;
    String value;

    Item(int t, String v) {
      timestamp = t;
      value = v;
    }

    public int compareTo(Item o) {
      return timestamp - o.timestamp;
    }
  }

  Map<String, List<Item>> values;

  /**
   * Initialize your data structure here.
   */
  public TimeMap() {
    values = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<Item> current = values.getOrDefault(key, new ArrayList<>());
    current.add(new Item(timestamp, value));
    values.put(key, current);
  }

  public String get(String key, int timestamp) {
    Item item = search(values.get(key), timestamp);
    return item != null ? item.value : "";
  }

  private Item search(List<Item> items, int timestamp) {
    if (items == null || items.size() == 0) return null;

    int idx = Collections.binarySearch(items, new Item(timestamp, null));
    if (idx < 0) {
      idx = Math.abs(idx + 1) - 1;
    }

    return idx >= 0 ? items.get(idx) : null;
  }
}
