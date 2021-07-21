import java.util.Stack;

/**
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/
 */
public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {
      if (asteroid > 0 || stack.empty()) {
        stack.push(asteroid);
      } else {
        boolean stop = false;
        boolean add = true;
        do {
          int lastAsteroid = stack.peek();
          if (lastAsteroid > 0) {
            int diff = Integer.compare(lastAsteroid, Math.abs(asteroid));

            if (diff == 0) {
              stack.pop();
              add = false;
              stop = true;
            }

            if (diff < 0) {
              stack.pop();
              stop = false;
            }

            if (diff > 0) {
              add = false;
              stop = true;
            }

          } else {
            stop = true;
          }
        } while (!stop && !stack.empty());

        if (add) {
          stack.push(asteroid);
        }
      }
    }

    int[] result = new int[stack.size()];
    int i = stack.size() - 1;
    while (!stack.isEmpty()) {
      result[i--] = stack.pop();
    }

    return result;
  }
}
