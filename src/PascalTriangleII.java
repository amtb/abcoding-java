import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
  public List<Integer> getRow(int rowIndex) {
    if (rowIndex == 0) {
      return Arrays.asList(1);
    }

    List<Integer> previousRow = getRow(rowIndex - 1);
    List<Integer> row = new ArrayList<>(previousRow.size() + 1);
    row.add(1);
    for (int i = 1; i < previousRow.size(); i++) {
      row.add(previousRow.get(i - 1) + previousRow.get(i));
    }
    row.add(1);

    return row;
  }
}
