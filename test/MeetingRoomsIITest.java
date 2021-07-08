import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingRoomsIITest {
  @ParameterizedTest
  @MethodSource("cases")
  void minMeetingRooms(int[][] intervals, int expected) {
    MeetingRoomsII solution = new MeetingRoomsII();
    assertEquals(expected, solution.minMeetingRooms(intervals));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        {0, 30},
        {5, 10},
        {15, 20}
      }, 2),
      Arguments.of(new int[][]{
        {7, 10},
        {2, 4}
      }, 1),
      Arguments.of(new int[][]{
        {9,10},
        {4,9},
        {4,17}
      }, 2),
      Arguments.of(new int[][]{
        {2,11},
        {6,16},
        {11,16}
      }, 2)
    );
  }
}
