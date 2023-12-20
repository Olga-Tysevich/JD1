package org.example.lesson10exceptions.custom_exception;

public class EmployeeOverloaded extends Exception{
    public EmployeeOverloaded(int maxNumberOfTasks) {
        super("Too many tasks. Maximum: " + maxNumberOfTasks);
    }
}
