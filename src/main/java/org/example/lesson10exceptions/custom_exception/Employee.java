package org.example.lesson10exceptions.custom_exception;

import static org.example.lesson10exceptions.custom_exception.Constants.*;

public class Employee {
    private String name;
    private int maxNumberOfTasks;
    private int minChanceToPersuade;
    private String message;

    public Employee(String name, int maxNumberOfTasks, int minChanceToPersuade) {
        this.name = name;
        this.maxNumberOfTasks = maxNumberOfTasks;
        this.minChanceToPersuade = minChanceToPersuade;
    }

    public void sendToWork(int numberOfTasks) {
        try {
            if (numberOfTasks <= maxNumberOfTasks) {
                message = POSITIVE_MESSAGE;
            } else {
                throw new EmployeeOverloaded(maxNumberOfTasks);
            }
        } catch (EmployeeOverloaded e) {
            message = NEGATIVE_MESSAGE;
            System.out.println(e.getMessage());
        } finally {
            System.out.println(message);
        }
    }

    public void persuadeToWork(int chanceToPersuade) throws EmployeeOverloaded {
        if (chanceToPersuade >= this.minChanceToPersuade) {
            System.out.println(SUCCESSFUL_ATTEMPT_MESSAGE);
        } else {
            throw new EmployeeOverloaded(maxNumberOfTasks);
        }
    }

    public void raiseWages() {
        System.out.println(POSITIVE_MESSAGE);
    }
}
