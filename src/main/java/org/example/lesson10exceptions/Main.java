package org.example.lesson10exceptions;

import org.example.lesson10exceptions.custom_exception.Employee;
import org.example.lesson10exceptions.custom_exception.EmployeeOverloaded;

public class Main {
    public static void main(String[] args) {
        /*Написать код, который выбрасывает NullPointerException.
         * Написать обработчик этого исключения и вывести на экран сообщение,
         * которое будет содержать описание данного исключения*/
        Notebook notebook = new Notebook();
        notebook.printNoteInLowerCase();
        System.out.println();

        /*Написать собственное исключение. Сгенерировать код, который будет его выбрасывать и обрабатывать.
        * Результат работы вывести на экран*/
        Employee employee = new Employee("John", 5, 10);
        employee.sendToWork(10);

        /*Написать метод, который будет возбуждать исключение и обработать это исключение на уровне выше.
        * Результат вывести на экран*/
        try {
            employee.persuadeToWork(5);
            System.out.println("Persuasion succeeded!");
        } catch (EmployeeOverloaded e) {
            System.out.println("Persuasion failed! We raise wages...");
            employee.raiseWages();
        }
    }
}
