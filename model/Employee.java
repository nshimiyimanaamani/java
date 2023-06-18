package model;

public class Employee extends Person {
    private String designation;

    public Employee(int id, String name, String designation) {
        super(id, name);
        this.designation = designation;

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    @Override
    public String getRole() {
        return "Employee";
    }
}
