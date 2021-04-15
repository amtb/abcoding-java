import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllocationTest {
  @ParameterizedTest
  @MethodSource("cases")
  void allocation(int[] houses, int budget, int expected) {
    assertEquals(expected, Allocation.getAllocation(houses, budget));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{20, 90, 40, 90}, 100, 2),
      Arguments.of(new int[]{30, 30, 10, 10}, 50, 3),
      Arguments.of(new int[]{999, 999, 999}, 300, 0)
    );
  }
}
