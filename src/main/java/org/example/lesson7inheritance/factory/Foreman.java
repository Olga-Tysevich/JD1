package org.example.lesson7inheritance.factory;

public class Foreman extends Worker{

    @Override
    public void calculateSalary() {
        System.out.println("Отдел: " + getDepartment() + ", начальник цеха: почасовая зарплата");
    }
}
