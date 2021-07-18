import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. Employee Importance
 * https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance {
  static class Employee {
    int id, importance;
    int[] subordinates;
  }

  public int getImportance(Map<Integer, Employee> tree, int id) {
    Employee employee = tree.get(id);

    int importance = employee.importance;
    for (int directReportId : employee.subordinates) {
      importance += getImportance(tree, directReportId);
    }

    return importance;
  }

  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> tree = new HashMap<>();

    for (Employee employee : employees) {
      tree.put(employee.id, employee);
    }

    return getImportance(tree, id);
  }
}
