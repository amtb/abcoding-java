import java.util.*;

/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {
  static enum EventType {
    START, END;
  }

  static class Event implements Comparable<Event> {
    int time;
    Meeting meeting;
    EventType type;

    Event(int t, Meeting m, EventType eventType) {
      time = t;
      meeting = m;
      type = eventType;
    }

    public int compareTo(Event o) {
      if (time == o.time) return o.type.compareTo(type);
      return time - o.time;
    }
  }

  static class Meeting {
    int start, end;

    Meeting(int[] interval) {
      start = interval[0];
      end = interval[1];
    }
  }

  /**
   * Sweep line
   * Create events (start/end of meetings) ordered
   * Go through the event stream
   * -> type = start, push to active meetings (set)
   * -> type = end, update min required (if needed) and remove from active meetings
   */
  public int minMeetingRooms(int[][] intervals) {
    List<Meeting> meetings = new ArrayList<>(intervals.length);
    for (int[] interval : intervals) meetings.add(new Meeting(interval));

    Queue<Event> events = new PriorityQueue<>(2 * intervals.length);
    for (Meeting m : meetings) {
      Event start = new Event(m.start, m, EventType.START);
      Event end = new Event(m.end, m, EventType.END);

      events.offer(start);
      events.offer(end);
    }

    Set<Meeting> activeMeetings = new HashSet<>();

    int min = 0;
    while (!events.isEmpty()) {
      Event event = events.poll();
      if (event.type == EventType.START) {
        activeMeetings.add(event.meeting);
      } else {
        min = Math.max(min, activeMeetings.size());
        activeMeetings.remove(event.meeting);
      }
    }

    return min;
  }
}
