package org.example.lesson7inheritance.factory;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new ChiefEngineer());
        employees.add(new Engineer());
        employees.add(new Foreman());
        employees.add(new Worker());

        employees.forEach(Employee::calculateSalary);
    }
}
