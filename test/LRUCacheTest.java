import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {
  @Test
  void testOne() {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    assertEquals(1, lRUCache.get(1));

    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    assertEquals(-1, lRUCache.get(2));

    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    assertEquals(-1, lRUCache.get(1));
    assertEquals(3, lRUCache.get(3));
    assertEquals(4, lRUCache.get(4));
  }

  @Test
  void testTwo() {
    LRUCache lRUCache = new LRUCache(1);
    lRUCache.put(2, 1);
    assertEquals(1, lRUCache.get(2));

    lRUCache.put(3, 2);
    assertEquals(-1, lRUCache.get(2));
    assertEquals(2, lRUCache.get(3));
  }

  @Test
  void testThree() {
    LRUCache lRUCache = new LRUCache(2);
    assertEquals(-1, lRUCache.get(2));

    lRUCache.put(2, 6);
    assertEquals(-1, lRUCache.get(1));

    lRUCache.put(1, 5);
    lRUCache.put(1, 2);
    assertEquals(2, lRUCache.get(1));
    assertEquals(6, lRUCache.get(2));
  }

  @Test
  void testFour() {
    LRUCache lRUCache = new LRUCache(10);
    lRUCache.put(10, 13);
    lRUCache.put(3, 17);
    lRUCache.put(6, 11);
    lRUCache.put(10, 5);
    lRUCache.put(9, 10);
    assertEquals(-1, lRUCache.get(13));
    lRUCache.put(2, 19);
    assertEquals(19, lRUCache.get(2));
    assertEquals(17, lRUCache.get(3));
    lRUCache.put(5, 25);
    assertEquals(-1, lRUCache.get(8));
    lRUCache.put(9, 22);
    lRUCache.put(5, 5);
    lRUCache.put(1, 30);
    assertEquals(-1, lRUCache.get(11));
    lRUCache.put(9, 12);
    assertEquals(-1, lRUCache.get(7));
    assertEquals(5, lRUCache.get(5));
    assertEquals(-1, lRUCache.get(8));
    assertEquals(12, lRUCache.get(9));
    lRUCache.put(4, 30);
    lRUCache.put(9, 3);
    assertEquals(3, lRUCache.get(9));
    assertEquals(5, lRUCache.get(10));
    assertEquals(5, lRUCache.get(10));
    lRUCache.put(6, 14);
    lRUCache.put(3, 1);
    assertEquals(1, lRUCache.get(3));
    lRUCache.put(10, 11);
    assertEquals(-1, lRUCache.get(8));
    lRUCache.put(2, 14);
    assertEquals(30, lRUCache.get(1));
    assertEquals(5, lRUCache.get(5));
    assertEquals(30, lRUCache.get(4));
    lRUCache.put(11, 4);
    lRUCache.put(12, 24);
    lRUCache.put(5, 18);
    assertEquals(-1, lRUCache.get(13));
    lRUCache.put(7, 23);
    assertEquals(-1, lRUCache.get(8));
    assertEquals(24, lRUCache.get(12));
    lRUCache.put(3, 27);
    lRUCache.put(2, 12);
    assertEquals(18, lRUCache.get(5));
    lRUCache.put(2, 9);
    lRUCache.put(13, 4);
    lRUCache.put(8, 18);
    lRUCache.put(1, 7);
    assertEquals(-1, lRUCache.get(6));
    lRUCache.put(9, 29);
    lRUCache.put(8, 21);
    assertEquals(18, lRUCache.get(5));
    lRUCache.put(6, 30);
    lRUCache.put(1, 12);
    assertEquals(-1, lRUCache.get(10));
    lRUCache.put(4, 15);
    lRUCache.put(7, 22);
    lRUCache.put(11, 26);
    lRUCache.put(8, 17);
    lRUCache.put(9, 29);
    assertEquals(18, lRUCache.get(5));
    lRUCache.put(3, 4);
    lRUCache.put(11, 30);
    assertEquals(-1, lRUCache.get(12));
    lRUCache.put(4, 29);
    assertEquals(4, lRUCache.get(3));
    assertEquals(29, lRUCache.get(9));
    assertEquals(30, lRUCache.get(6));
    lRUCache.put(3, 4);
    assertEquals(12, lRUCache.get(1));
    assertEquals(-1, lRUCache.get(10));
    lRUCache.put(3, 29);
    lRUCache.put(10, 28);
    lRUCache.put(1, 20);
    lRUCache.put(11, 13);
    assertEquals(29, lRUCache.get(3));
    lRUCache.put(3, 12);
    lRUCache.put(3, 8);
    lRUCache.put(10, 9);
    lRUCache.put(3, 26);
    assertEquals(17, lRUCache.get(8));
    assertEquals(22, lRUCache.get(7));
    assertEquals(18, lRUCache.get(5));
    lRUCache.put(13, 17);
    lRUCache.put(2, 27);
    lRUCache.put(11, 15);
    assertEquals(-1, lRUCache.get(12));
    lRUCache.put(9, 19);
    lRUCache.put(2, 15);
    lRUCache.put(3, 16);
    assertEquals(20, lRUCache.get(1));
    lRUCache.put(12, 17);
    lRUCache.put(9, 1);
    lRUCache.put(6, 19);
    assertEquals(-1, lRUCache.get(4));
    assertEquals(18, lRUCache.get(5));
    assertEquals(18, lRUCache.get(5));
    lRUCache.put(8, 1);
    lRUCache.put(11, 7);
    lRUCache.put(5, 2);
    lRUCache.put(9, 28);
    assertEquals(20, lRUCache.get(1));
    lRUCache.put(2, 2);
    lRUCache.put(7, 4);
    lRUCache.put(4, 22);
    lRUCache.put(7, 24);
    lRUCache.put(9, 26);
    lRUCache.put(13, 28);
    lRUCache.put(11, 26);
  }
}
