/**
 * 1423. Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaximumPointsYouCanObtainfromCards {
  private int sum(int[] cards, int fromIndex, int toIndex) {
    int sum = 0;

    for (int i = fromIndex; i <= toIndex; i++) {
      sum += cards[i];
    }

    return sum;
  }

  public int maxScore(int[] cards, int k) {
    int start = 0;
    int end = cards.length - 1;

    if (cards.length == k) return sum(cards, 0, end);

    int sumStart = sum(cards, 0, k - 1);
    int sumEnd = sum(cards, end - k + 1, end);

    int max = 0;
    for (int i = 1; i <= k; i++) {
      if (sumStart == sumEnd) {
        if (cards[start] < cards[end]) {
          max += cards[end];
          sumStart -= cards[start + k - i];
          sumEnd -= cards[end];
          end -= 1;
        } else {
          max += cards[start];
          sumStart -= cards[start];
          sumEnd -= cards[end - k + i];
          start += 1;
        }
      } else if (sumStart < sumEnd) {
        max += cards[end];
        sumStart -= cards[start + k - i];
        sumEnd -= cards[end];
        end -= 1;
      } else {
        max += cards[start];
        sumStart -= cards[start];
        sumEnd -= cards[end - k + i];
        start += 1;
      }
    }

    return max;
  }
}
