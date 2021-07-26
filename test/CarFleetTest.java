import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarFleetTest {
  @ParameterizedTest
  @MethodSource("cases")
  void carFleet(int target, int[] position, int[] speed, int output) {
    CarFleet solution = new CarFleet();
    assertEquals(output, solution.carFleet(target, position, speed));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}, 3),
      Arguments.of(10, new int[]{3}, new int[]{3}, 1),
      Arguments.of(10, new int[]{0,4,2}, new int[]{2,1,3}, 1)
    );
  }
}
