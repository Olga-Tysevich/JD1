package org.example.lesson7inheritance.factory;

public class ChiefEngineer extends Engineer{

    @Override
    public void calculateSalary() {
        System.out.println("Отдел: " + getDepartment() + ", главный инженер: процентная зарплата");
    }

}
