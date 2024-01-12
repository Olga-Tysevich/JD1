package org.example.lesson17solid.builder;

public class SimplePersonBuilder implements PersonBuilder {
    private final int YEAR_LENGTH = 4;
    private String name;
    private String surname;
    private String yearOfBirth;


    public SimplePersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SimplePersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public SimplePersonBuilder setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    @Override
    public Person createPerson() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name!");
        } else if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Invalid surname!");
        } else if (yearOfBirth.length() != YEAR_LENGTH) {
            throw new IllegalArgumentException("Invalid year!");
        } else {
            return new Person(name, surname, yearOfBirth);
        }
    }
}
