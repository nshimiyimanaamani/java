package managment;

import java.util.List;

import model.Employee;

public interface EmployeeManagement {
    void addEmployee(Employee employee);
    void removeEmployee(Employee employee);
    List<Employee> getAllEmployees();
}