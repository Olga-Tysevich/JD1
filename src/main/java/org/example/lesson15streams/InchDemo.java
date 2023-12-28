package org.example.lesson15streams;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class InchDemo {
    private static final double CM_IN_INCH = 2.54;
    private static final int MIN_INCH_VALUE = 1;
    private static final int MAX_INCH_VALUE = 20;
    private static final IntPredicate EVEN_NUMBER = n -> n % 2 == 0;

    public static void main(String[] args) {
        /*Напишите программу, которая для всех четных значений длинной от 1 до 20 дюймов:
        * печатает на экран значения в дюймах
        * переводит значения в сантиметры
        * печатает на экран сумму в сантиметрах*/

        double sum = IntStream.rangeClosed(MIN_INCH_VALUE, MAX_INCH_VALUE)
                .filter(EVEN_NUMBER)
                .peek(n -> System.out.print(n + " inch - "))
                .mapToDouble(inch -> inch * CM_IN_INCH)
                .peek(n -> System.out.println(n + " cm"))
                .sum();
        System.out.println("Sum: " + sum + " cm");


    }
}
