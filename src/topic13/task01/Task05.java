package topic13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task05 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John"));
        employeeList.add(new Employee(2, "Jane"));
        employeeList.add(new Employee(3, "Alice"));

        Map<Integer, String> employeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));

        System.out.println(employeeMap);
    }
}
