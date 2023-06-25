package main;

import model.Employee;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add an employee");
            System.out.println("2. Retrieve all employees");
            System.out.println("3. Retrieve an employee by ID");
            System.out.println("4. Retrieve employees by IDs");
            System.out.println("5. Update an employee");
            System.out.println("6. Delete an employee");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Adding an employee
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    float salary = scanner.nextFloat();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee gender: ");
                    String gender = scanner.nextLine();

                    Employee employee = new Employee(id, name,gender,designation, salary);
                    repository.addEmployee(employee);
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    // Retrieving all employees
                    List<Employee> allEmployees = repository.getAllEmployees();
                    if (allEmployees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("All Employees:");
                        for (Employee emp : allEmployees) {
                            System.out.println(emp.getName() + " - " + emp.getDesignation() + " - " + emp.getSalary() + " - " + emp.getGender());
                        }
                    }
                    break;
                case 3:
                    // Retrieving an employee by ID
                    System.out.print("Enter employee ID to retrieve: ");
                    int retrieveId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Employee retrievedEmployee = repository.getEmployeeById(retrieveId);
                    if (retrievedEmployee == null) {
                        System.out.println("Employee not found with the given ID.");
                    } else {
                        System.out.println("Retrieved Employee:");
                        System.out.println(retrievedEmployee.getName() + " - " + retrievedEmployee.getDesignation() + " - " + retrievedEmployee.getSalary() + " - " + retrievedEmployee.getGender());
                    }
                    break;
                case 4:
                    // Retrieving employees by IDs
                    System.out.print("Enter employee IDs (comma-separated): ");
                    String idListInput = scanner.nextLine();
                    String[] idStrings = idListInput.split(",");
                    List<Integer> ids = new ArrayList<>();
                    for (String idString : idStrings) {
                        ids.add(Integer.parseInt(idString.trim()));
                    }

                    List<Employee> employeesByIds = repository.getEmployeeById(ids);
                    if (employeesByIds.isEmpty()) {
                        System.out.println("No employees found with the given IDs.");
                    } else {
                        System.out.println("Employees:");
                        for (Employee emp : employeesByIds) {
                            System.out.println(emp.getName() + " - " + emp.getDesignation() + " - " + emp.getSalary() + " - " + emp.getGender());
                        }
                    }
                    break;
                case 5:
                    // Updating an employee
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Employee updateEmployee = repository.getEmployeeById(updateId);
                    if (updateEmployee == null) {
                        System.out.println("Employee not found with the given ID.");
                    } else {
                        System.out.print("Enter employee name: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("Enter employee designation: ");
                        String updatedDesignation = scanner.nextLine();
                        System.out.print("Enter employee salary: ");
                        float updatedSalary = scanner.nextFloat();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter employee gender: ");
                        String updatedGender = scanner.nextLine();

                        updateEmployee.setName(updatedName);
                        updateEmployee.setDesignation(updatedDesignation);
                        updateEmployee.setSalary(updatedSalary);
                        updateEmployee.setGender(updatedGender);

                        repository.updateEmployee(updateEmployee);
                        System.out.println("Employee updated successfully.");
                    }
                    break;
                case 6:
                    // Deleting an employee
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Employee deleteEmployee = repository.getEmployeeById(deleteId);
                    if (deleteEmployee == null) {
                        System.out.println("Employee not found with the given ID.");
                    } else {
                        repository.removeEmployee(deleteEmployee);
                        System.out.println("Employee deleted successfully.");
                    }
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println(); // Print an empty line for better readability
        }

        // Close the scanner
        scanner.close();
    }
}
