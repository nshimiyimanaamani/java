package model;

public class Employee extends Person {
    private String designation;
    private float salary;

    public Employee(int id, String name, String gender,String designation, float salary) {
        super(id, name,gender);
        this.designation = designation;
        this.salary = salary;

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public float getSalary() {
        return salary;
    }
    @Override
    public String getRole() {
        return "Employee";
    }
}
