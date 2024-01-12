package org.example.lesson17solid;

import org.example.lesson17solid.builder.Person;
import org.example.lesson17solid.builder.PersonCreator;
import org.example.lesson17solid.builder.SimplePersonBuilder;

public class Main {
    private static final String FILE_PATH = "src\\main\\java\\org\\example\\lesson17solid\\log.txt";

    public static void main(String[] args) {
        /*Создайте простейший сервис с методом, который выводит на экран текщую дату.
         * Сделайте его Singleton и используйте в основном теле программы*/
        DateSingleton singleton = DateSingleton.getDateSingleton();
        singleton.printCurrentDate();

        /*Создайте класс Person с полями имя, фамилия, год рождения.
         * Реализуйте у этого класса паттерн Строитель. Введите с клавиатуры и заполните объект
         * класса Person с помощью паттерна Строитель*/
        Person person = new PersonCreator(new SimplePersonBuilder()).createPerson();
        System.out.println(person);

        /*Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл.
        * Объект логгера должен быть создан с помощью Singleton. У объекта должен быть обязательным один метод,
        * получающий на вход текст сообщения об ошибке и записывающий его в файл вместе с информацией о дате и времени происшествия*/
        Logger logger = Logger.getInstance(FILE_PATH);
        logger.logErrorMessages("An unknown error has occurred");
        logger.logErrorMessages("A critical error has occurred");
        logger.logErrorMessages("A catastrophic error has occurred");
        logger.logErrorMessages("Everything is broken");
        logger.logErrorMessages("A universal explosion occurred");
    }

}

