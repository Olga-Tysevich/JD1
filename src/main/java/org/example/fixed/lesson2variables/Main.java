package org.example.fixed.lesson2variables;


public class Main {
    private static final int SEC_IN_MIN = 60;
    private static final int MIN_IN_HOUR = 60;
    private static final int HOUR_IN_DAY = 24;
    private static final int DAY_IN_WEEK = 7;

    public static void main(String[] args) {
        /* Написать метод, который принимает на вход два целых числа, делает их суммиирование,
        складывает результат с их произведением и возвращает результат.
        Результат вывести на экран
        */
        System.out.println(calculateSumOfSumAndProduct(1, 5));

        /* Задать промежуток времени в секундах в виде переменной. Вывести его на экран в виде часов, минут,
        секунд, дней, недель
        */
        long timeInSec = 1904500L;
        printTime(timeInSec);

    }

    public static int calculateSumOfSumAndProduct(int a, int b) {
        return ((a + b) + (a * b));
    }

    public static void printTime(long timeInSec) {
        long sec = timeInSec % SEC_IN_MIN;
        long m = (timeInSec - sec) / SEC_IN_MIN;
        long min = m % MIN_IN_HOUR;
        long h = (m - min) / MIN_IN_HOUR;
        long hours = h % HOUR_IN_DAY;
        long d = (h - hours) / HOUR_IN_DAY;
        long days = d % DAY_IN_WEEK;
        long weeks = d / DAY_IN_WEEK;
        System.out.println(weeks + " weeks " + days + " days " + hours + ":" + min + ":" + sec);
    }

}
