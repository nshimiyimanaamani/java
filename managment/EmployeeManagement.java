package managment;

import model.Employee;

import java.util.List;

public interface EmployeeManagement {
    void addEmployee(Employee employee);
    void removeEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
}
