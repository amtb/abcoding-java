import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sliding-puzzle/
 */
public class SlidingPuzzle {
  public int slidingPuzzle(int[][] board) {
    Board b = new Board(board);
    Solver s = new Solver(b);
    return s.moves();
  }

  private class Solver {
    private final Board initialBoard;
    private int steps;

    public Solver(Board initial) {
      initialBoard = initial;
      computeStepsToSolution();
    }

    public int moves() {
      return steps;
    }

    // computes the step the solution by creating two queues: with the initial board, and with a twin board (swapped any pair of tiles)
    // the first board that get solved, means the other can't be.
    // using in a priority queue of board sorted by number of moves + distance to goal
    // each cycle does the following
    // - remove the board with the best priority from the queue
    // - check we we found the solution
    // - adds the neighbors of the board (by moving the empty tile)
    private void computeStepsToSolution() {

      PriorityQueue<SearchNode> mainQueue = new PriorityQueue<SearchNode>();
      mainQueue.offer(new SearchNode(initialBoard, 0, null));

      PriorityQueue<SearchNode> twinQueue = new PriorityQueue<SearchNode>();
      twinQueue.offer(new SearchNode(initialBoard.twin(), 0, null));

      SearchNode mainPath;
      SearchNode twinPath = null;
      do {
        mainPath = dequeue(mainQueue);
        if (mainPath == null) {
          twinPath = dequeue(twinQueue);
        }
      } while (mainPath == null && twinPath == null);

      if (mainPath != null) {
        steps = 0;
        while (mainPath.previous != null) {
          steps += 1;
          mainPath = mainPath.previous;
        }
      } else {
        steps = -1;
      }
    }

    private SearchNode dequeue(PriorityQueue<SearchNode> queue) {
      SearchNode currentNode = queue.poll();
      Board board = currentNode.board;

      if (board.isGoal()) {
        return currentNode;
      }

      Board previousBoard = null;
      if (currentNode.previous != null) {
        previousBoard = currentNode.previous.board;
      }

      for (Board neighbor : board.neighbors()) {
        if (!neighbor.equals(previousBoard)) {
          queue.offer(new SearchNode(neighbor, currentNode.moves + 1, currentNode));
        }
      }

      return null;
    }

    private class SearchNode implements Comparable<SearchNode> {
      final int priority;
      Board board;
      int moves;
      SearchNode previous;

      public SearchNode(Board b, int m, SearchNode p) {
        board = b;
        moves = m;
        previous = p;
        priority = moves + board.manhattan();
      }

      public int compareTo(SearchNode searchNode) {
        return priority - searchNode.priority;
      }
    }
  }

  private class Board {
    private Board goal;
    private final int[][] tiles;
    private final int n;
    private final int m;

    public Board(int[][] tiles) {
      n = tiles.length;
      m = tiles[0].length;
      this.tiles = tiles;
    }

    private int[][] clone(int[][] someTiles) {
      int[][] cloned = new int[n][];
      for (int i = 0; i < n; i++) {
        cloned[i] = someTiles[i].clone();
      }

      return cloned;
    }

    public int manhattan() {
      int distance = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int tile = tiles[i][j];
          if (tile != 0) {
            int r = (tile - 1) / n;
            int c = (tile - 1) % m;
            distance += Math.abs(r - i) + Math.abs(c - j);
          }
        }
      }

      return distance;
    }

    public boolean isGoal() {
      if (goal == null) {
        int[][] goalTiles = new int[n][];
        for (int i = 0; i < n; i++) {
          goalTiles[i] = new int[m];
          for (int j = 0; j < m; j++) {
            goalTiles[i][j] = i * m + j + 1;
          }
        }
        goalTiles[n - 1][m - 1] = 0;
        goal = new Board(goalTiles);
      }
      return equals(goal);
    }

    public boolean equals(Object y) {
      if (null != y && y.getClass() == this.getClass()) {
        if (this == y) return true;

        Board other = (Board) y;
        if (other.n != n) return false;

        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (other.tiles[i][j] != tiles[i][j]) return false;
          }
        }

        return true;
      }

      return false;
    }

    public Iterable<Board> neighbors() {
      List<Board> boards = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (tiles[i][j] == 0) {
            if (i > 0) boards.add(new Board(cloneAndSwap(i, j, i - 1, j)));
            if (i < n - 1) boards.add(new Board(cloneAndSwap(i, j, i + 1, j)));
            if (j > 0) boards.add(new Board(cloneAndSwap(i, j, i, j - 1)));
            if (j < m - 1) boards.add(new Board(cloneAndSwap(i, j, i, j + 1)));
            return boards;
          }
        }
      }

      return null;
    }

    public Board twin() {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m - 1; j++) {
          if (tiles[i][j] != 0 && tiles[i][j + 1] != 0) return new Board(cloneAndSwap(i, j, i, j + 1));
        }
      }

      return null;
    }

    private int[][] cloneAndSwap(int i, int j, int r, int c) {
      int[][] newTiles = clone(tiles);
      int tile = newTiles[i][j];
      newTiles[i][j] = newTiles[r][c];
      newTiles[r][c] = tile;

      return newTiles;
    }
  }
}

