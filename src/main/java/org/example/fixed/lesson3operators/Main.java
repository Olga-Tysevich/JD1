package org.example.fixed.lesson3operators;

import org.example.fixed.lesson3operators.date.CustomDate;
import org.example.fixed.lesson3operators.figures.Circle;
import org.example.fixed.lesson3operators.figures.Rectangle;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int NUMBER_LAST_DAY_OF_WEEK = 7;
    public static void main(String[] args) {
        /*Создайте метод с одним целочисленным параметром. Метод должен определить,
        явлется ли последняя цифра семеркой и вернуть boolean
        */
        System.out.println(isLastDigitSeven(100));
        System.out.println(isLastDigitSeven(1007));
        System.out.println(isLastDigitSeven(1005));

        /* Имеется прямоугольное отверстие размерами a, b, где a, b - целые числа.
        Определить, можно ли его полностью закрыть круглой картонкой радиусом r (целое число)
        */
        Rectangle rectangle = new Rectangle(6, 8);
        Circle circle = new Circle(4);
        isHoleCovered(rectangle, circle);

        /* Задайте целое число в виде переменной, это число - сумма денег в рублях. Вывести это число на экран, добавив к нему
        слово в правильном падеже
        */
        List<Integer> amountOfMoney = List.of(0, 1, 3, 5, 8, 10, 15, 20, 21, 25, 101, 110, 121);
        amountOfMoney.forEach(Main::printAmountOfMoney);

        // Задайте три числа - день, месяц, год. Вывести на экран в виде трех чисел дату следующего дня
        CustomDate date = new CustomDate(12, 5, 2020);
        CustomDate date2 = new CustomDate(31, 12, 2020);
        date.printNextDay();
        date2.printNextDay();

        /* Имеются два дома размерами а на b. Имеется участок размерами е на f. Проверить, помещаются ли эти дома на данном участке.
        Стороны домов - параллельны сторонам участка, в остальном размещение может быть любым
        * */
        int a = new Random().nextInt(100) + 1;
        int b = new Random().nextInt(100) + 1;
        int c = new Random().nextInt(100) + 1;
        int d = new Random().nextInt(100) + 1;
        int e = new Random().nextInt(100) + 1;
        int f = new Random().nextInt(100) + 1;

        if ((b + d) < f && Math.max(a, c) < e || (a + c) < e && Math.max(b, d) < f) {
            System.out.println("houses with a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + " are located on the site with e=" + e + ", f=" + f);
        } else {
            System.out.println("houses with a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + " do not fit on the site with e=" + e + ", f=" + f);
        }

        /* Написать метод, который выводит расписание на неделю. Задать на вход в метод порядковый номер дня недели и отобразить на экране то,
        что запланировано на этот день
        * */
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.stream(days).forEach(Main::getTask);
    }

    public static void getTask(int dayOfWeekNumber) throws IllegalArgumentException {
        if (dayOfWeekNumber > 0 && dayOfWeekNumber <= NUMBER_LAST_DAY_OF_WEEK) {
            switch (dayOfWeekNumber) {
                case 1 -> System.out.println("some plans for Monday");
                case 2 -> System.out.println("some plans for Tuesday");
                case 3 -> System.out.println("some plans for Wednesday");
                case 4 -> System.out.println("some plans for Thursday");
                case 5 -> System.out.println("some plans for Friday");
                case 6 -> System.out.println("some plans for Saturday");
                case 7 -> System.out.println("some plans for Sunday");
            }
        } else {
            throw new IllegalArgumentException("Invalid day of week number!");
        }
    }

    public static void printAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney % 10 == 0 || amountOfMoney % 10 >= 5) {
            System.out.println(amountOfMoney + " рублей");
        } else if (amountOfMoney % 10 == 1) {
            System.out.println(amountOfMoney + " рубль");
        } else if (amountOfMoney % 10 >= 2 && amountOfMoney <= 4) {
            System.out.println(amountOfMoney + " рубля");
        }
    }

    public static void isHoleCovered(Rectangle rectangle, Circle circle) {
        if (rectangle.getDiagonal() <= circle.getDiagonal()) {
            System.out.println("Картонка с радиусом: " + circle.getRadius() + " закрывает отверстие со сторонами а: " + rectangle.getA()
                    + " b: " + rectangle.getB());
        } else {
            System.out.println("Картонка с радиусом: " + circle.getRadius() + " не закрывает отверстие со сторонами а: " + rectangle.getA()
                    + " b: " + rectangle.getB());
        }
    }

    public static boolean isLastDigitSeven(int number) {
        return number % 10 == 7;
    }
}
