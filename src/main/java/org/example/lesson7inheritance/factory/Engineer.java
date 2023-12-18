package org.example.lesson7inheritance.factory;

public class Engineer extends Employee{
    public Engineer() {
        super("Инженерный отдел");
    }

    @Override
    public void calculateSalary() {
        System.out.println("Отдел: " + getDepartment() + ", инженер: смешанная зарплата");
    }
}
