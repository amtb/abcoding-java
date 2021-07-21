import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AsteroidCollisionTest {
  @ParameterizedTest
  @MethodSource("cases")
  void asteroidCollision(int[] asteroids, int[] expected) {
    AsteroidCollision solution = new AsteroidCollision();
    assertArrayEquals(expected, solution.asteroidCollision(asteroids));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{5,10,-5}, new int[] {5, 10}),
      Arguments.of(new int[]{8,-8}, new int[] {}),
      Arguments.of(new int[]{10,2,-5}, new int[] {10}),
      Arguments.of(new int[]{-2,-1,1,2}, new int[] {-2,-1,1,2})
    );
  }
}
