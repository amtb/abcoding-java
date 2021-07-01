import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * https://leetcode.com/problems/logger-rate-limiter/
 */
public class LoggerRateLimiter {
  Map<String, Integer> nextPrints;

  /** Initialize your data structure here. */
  public LoggerRateLimiter() {
    nextPrints = new HashMap<>();
  }

  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    Integer nextPrint = nextPrints.getOrDefault(message, null);
    if (nextPrint == null || timestamp >= nextPrint) {
      nextPrints.put(message, timestamp + 10);
      return true;
    }

    return false;
  }
}
