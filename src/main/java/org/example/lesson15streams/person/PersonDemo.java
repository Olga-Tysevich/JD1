package org.example.lesson15streams.person;

import org.example.lesson11files.person.Names;
import org.example.lesson11files.person.Surnames;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonDemo {
    private static final int GROUP_SIZE = 100;
    private static final int MIN_AGE = 15;
    private static final int RANDOM_AGE_RANGE = 16;
    private static final int REQUIRED_NUMBER_OF_PERSONS = 4;
    private static final Predicate<Person> PERSON_UNDER_21 = p -> p.getAge() < 21;

    public static void main(String[] args) {
        /*Создайте класс Person с полями name, surname, age. Сгенерируйте группу из 100 человек
        * в возрасте от 15 до 30. Напишите одну непрерывную цепочку stream вызовов, которая:
        * выбирает объекты, возраст которых меньше 21
        * распечатывает их на экран
        * сортирует по фамилии, а потом по имени
        * берет 4 первых объекта
        * формирует коллекцию из фамилий объектов
        * агрегиует все в коллекцию*/
        List<String> surnames = Stream.generate(PersonDemo::generatePerson)
                .limit(GROUP_SIZE)
                .filter(PERSON_UNDER_21)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname)
                        .thenComparing(Person::getName))
                .limit(REQUIRED_NUMBER_OF_PERSONS)
                .map(Person::getSurname)
                .collect(Collectors.toList());

        System.out.println(surnames);
    }

    public static Person generatePerson() {
        return new Person(
                Names.values()[new Random().nextInt(Names.values().length)].name(),
                Surnames.values()[new Random().nextInt(Surnames.values().length)].name()
                + "-" + Surnames.values()[new Random().nextInt(Surnames.values().length)].name(),
                new Random().nextInt(RANDOM_AGE_RANGE) + MIN_AGE);
    }
}
