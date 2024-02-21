import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDirectory {

    private List<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.contains(employee)) return;
        employees.add(employee);
    }

    public List<Employee> searchEmployeesByWorkExp(int workExperience) {
        return employees.stream().filter(e -> e.getWorkExperience() == workExperience).
                collect(Collectors.toList());
    }

    public List<String> searchPhoneNumbers(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .map(Employee::getPhoneNumbers)
                .orElse(Collections.emptyList());
    }

    public Employee searchEmployeeByPersonalId(int id) {
        return employees.stream().filter(e -> e.getPersonalId() == id).findFirst().orElse(null);
    }
}
