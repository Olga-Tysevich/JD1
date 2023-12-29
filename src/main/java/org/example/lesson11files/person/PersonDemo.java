package org.example.lesson11files.person;

import org.example.lesson11files.service.CustomReader;
import org.example.lesson11files.service.CustomWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*52) Создать объект Person с полями name, surname, age. Сгенерировать 10 объектов этого класса
 * со случайными полями соответствующего типа.
 * С помощью Java создать файл, в который запишется информация о этих людях*/
public class PersonDemo {
    private static final String FILE_PATH = "src/main/java/org/example/lesson11files/person/Persons.txt";
    private static final int PERSON_LIST_SIZE = 10;
    private static final int MAX_PERSON_AGE = 100;

    public static void main(String[] args) {
        List<Person> personList = generatePersons(PERSON_LIST_SIZE);
        CustomReader reader = new CustomReader();
        CustomWriter writer = new CustomWriter();
        writer.writeObject(personList, FILE_PATH);
        List<Object> persons = reader.readObject(FILE_PATH);
        for (Object o : persons) {
            System.out.println(o);
        }
    }

    public static List<Person> generatePersons(int numberOfPersons) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < numberOfPersons; i++) {
            String randomName = Names.values()[new Random().nextInt(Names.values().length - 1)].name();
            String randomSurname = Surnames.values()[new Random().nextInt(Surnames.values().length - 1)].name();
            int randomAge = new Random().nextInt(MAX_PERSON_AGE) + 1;
            personList.add(new Person(randomName, randomSurname, randomAge));
        }
        return personList;
    }
}
