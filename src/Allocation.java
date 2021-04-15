import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int budget = in.nextInt();

      int[] houses = new int[n];
      for (int j = 0; j < n; j++) {
        houses[j] = in.nextInt();
      }

      int allocation = getAllocation(houses, budget);
      System.out.println("Case #" + i + ": " + allocation);
    }
  }

  public static int getAllocation(int[] houses, int budget) {
    Arrays.sort(houses);

    int canBuy = 0;
    for (int i = 0; i < houses.length && budget >= houses[i]; i++) {
      budget -= houses[i];
      canBuy += 1;
    }

    return canBuy;
  }
}

