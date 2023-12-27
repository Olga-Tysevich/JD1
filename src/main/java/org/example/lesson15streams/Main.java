package org.example.lesson15streams;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /*Напишите программу, которая для всех четных значений длинной от 1 до 20 дюймов:
        * печатает на экран значения в дюймах
        * переводит значения в сантиметры
        * печатает на экран сумму в сантиметрах*/

        double sum = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.print(n + " inch - "))
                .mapToDouble(d -> d * 2.54)
                .peek(n -> System.out.println(n + " cm"))
                .sum();
        System.out.println("Sum: " + sum + " cm");
    }
}
