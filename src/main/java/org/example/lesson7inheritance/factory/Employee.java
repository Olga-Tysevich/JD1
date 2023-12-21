package org.example.lesson7inheritance.factory;

public abstract class Employee {
    private String department;

    public Employee(String department) {
        this.department = department;
    }

    public abstract void calculateSalary();

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
