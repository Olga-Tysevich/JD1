package org.example.lesson8generics_enum.seaons;

import java.util.Arrays;
import java.util.Scanner;

public class SeasonsDemo {
    public static void main(String[] args) {
        /*Создать enum, который описывает сезоны года.
        Добавить поля description, countOfDays. Вывести на экран все константы * */
        Arrays.stream(Seasons.values()).forEach(System.out::println);

        /*Написать метод, который выводит следующий сезон от заданного во входном параметре.
         * Входной параметр ввести с клавиатуры*/
        Seasons.printNextSeason(getSeason());

        /*Написать метод, который в зависимости от сезона, выводит на экран сумму дней в этом сезоне.
         * Входной параметр ввести с клавиатуры*/
        Seasons.printCountOfDays(getSeason());

    }

    public static Seasons getSeason() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input season: ");
            String seasonName = scanner.nextLine();
            if (checkInputSeason(seasonName.toUpperCase())) {
                return Seasons.valueOf(seasonName.toUpperCase());
            } else {
                for (Seasons s : Seasons.values()) {
                    if (s.getDescription().equalsIgnoreCase(seasonName)) {
                        return s;
                    }
                }
            }
            System.out.println("There is no such season!");
        }
    }

    private static boolean checkInputSeason(String seasonName) {
        try {
            Seasons.valueOf(seasonName);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
