package org.example.lesson17solid.builder;

public interface PersonBuilder {
    PersonBuilder setName(String name);
    PersonBuilder setSurname(String surname);
    PersonBuilder setYearOfBirth(String yearOfBirth);
    Person createPerson();
}
