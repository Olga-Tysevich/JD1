package org.example.lesson15streams;

import java.util.Random;

public class IntListDemo {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 1001;
    public static final int LIST_SIZE = 500;

    public static void main(String[] args) {
        /*Сгенерировать List коллекцию целых чисел из n элементов от minValue до maxValue.
         *Определить содержатся ли в данной коллекции числа, которые деляся и на 3 и на 5 с помощью stream*/
        System.out.println(new Random().ints(LIST_SIZE, MIN_VALUE, MAX_VALUE).anyMatch(n -> n % 3 == 0 && n % 5 == 0));
    }
}
