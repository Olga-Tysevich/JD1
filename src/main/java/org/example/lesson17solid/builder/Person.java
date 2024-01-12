package org.example.lesson17solid.builder;

public class Person {
    private String name;
    private String surname;
    private String yearOfBirth;

    public Person(String name, String surname, String yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Name='" + name +
                ", surname='" + surname +
                ", yearOfBirth='" + yearOfBirth;
    }
}
