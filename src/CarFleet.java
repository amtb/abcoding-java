import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 853. Car Fleet
 * https://leetcode.com/problems/car-fleet/
 */
public class CarFleet {
  static class Car {
    int position, speed;

    Car(int p, int s) {
      position = p;
      speed = s;
    }

    double timeTo(int target) {
      return ((double) (target - position)) / speed;
    }

    void update(int p, int s) {
      position = p;
      speed = s;
    }
  }

  public int carFleet(int target, int[] position, int[] speed) {
    List<Car> cars = new ArrayList<>(position.length);

    for (int i = 0; i < position.length; i++) {
      cars.add(new Car(position[i], speed[i]));
    }

    Collections.sort(cars, (l, r) -> r.position - l.position);

    int fleetSize = cars.size();
    for (int i = 0; i < cars.size() - 1; i++) {
      Car car = cars.get(i);
      Car previous = cars.get(i + 1);

      // Am I slower ?
      if (Double.compare(car.timeTo(target), previous.timeTo(target)) >= 0) {
        previous.update(car.position, car.speed);
        fleetSize -= 1;
      }
    }

    return fleetSize;
  }
}
