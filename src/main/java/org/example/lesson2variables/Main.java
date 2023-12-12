package org.example.lesson2variables;


public class Main {

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
        int sec = 3700 % 60;
        long m = (timeInSec - sec) / 60;
        long min = m % 60;
        long h = (m - min) / 60;
        long hours = h % 24;
        long d = (h - hours) / 24;
        long days = d % 7;
        long weeks = d / 7;
        System.out.println(weeks + " weeks " + days + " days " + hours + ":" + min + ":" + sec);
    }

}
