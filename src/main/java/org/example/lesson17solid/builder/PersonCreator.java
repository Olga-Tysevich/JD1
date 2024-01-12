package org.example.lesson17solid.builder;

import java.util.Scanner;

public class PersonCreator {
    PersonBuilder personBuilder;

    public PersonCreator(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public Person createPerson() {
        return personBuilder.setName(getData())
                .setSurname(getData())
                .setYearOfBirth(getData())
                .createPerson();
    }

    private String getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input data: ");
        return scanner.nextLine();
    }
}
