package org.example.lesson7inheritance.factory;

public class Worker extends Employee{
    public Worker() {
        super("Производственный цех");
    }

    @Override
    public void calculateSalary() {
        System.out.println("Отдел: " + getDepartment() + ", рабочий: Зарплата в процентах");
    }
}
