import java.util.*;

/**
 * 1834. Single-Threaded CPU
 * https://leetcode.com/problems/single-threaded-cpu/
 */
public class SingleThreadedCPU {
  static class Task {
    int start, length, index;

    Task(int s, int l, int i) {
      start = s;
      length = l;
      index = i;
    }
  }

  public int[] getOrder(int[][] tasks) {
    List<Integer> result = new ArrayList<>(tasks.length);
    Task[] list = new Task[tasks.length];

    for (int i = 0; i < tasks.length; i++) {
      list[i] = new Task(tasks[i][0], tasks[i][1], i);
    }

    Arrays.sort(list, Comparator.comparingInt(t -> t.start));

    Queue<Task> toProcess = new PriorityQueue<>((l, r) -> {
      if (l.length == r.length) return l.index - r.index;
      return l.length - r.length;
    });

    int index = 0;
    int time = list[index].start;

    while (index < tasks.length) {
      while (index < tasks.length && list[index].start <= time) {
        toProcess.offer(list[index]);
        index += 1;
      }

      // process next task if any
      if (!toProcess.isEmpty()) {
        Task next = toProcess.poll();
        result.add(next.index);
        time += next.length;
      } else if (index < tasks.length) { // jump to the next task
        time = list[index].start;
      }
    }

    while (!toProcess.isEmpty()) result.add(toProcess.poll().index);

    int[] r = new int[result.size()];
    for (int i = 0; i < r.length; r[i] = result.get(i++)) ;
    return r;
  }
}
