package org.example.lesson9collections;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        /*Создать список оценок учеников с помощбю ArrayList, заполнить случайными оценками.
        Удалить неудовлетворительные оценки из списка*/
        List<Integer> mark1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mark1.add(new Random().nextInt(5) + 1);
            System.out.print(mark1.get(i) + ", ");
        }
        System.out.println();

        Iterator<Integer> iterator = mark1.listIterator();
        while (iterator.hasNext()) {
            Integer mark = iterator.next();
            if (mark < 4) {
                iterator.remove();
            }
        }
        mark1.forEach(m -> System.out.print(m + ", "));
        System.out.println("\n");


        List<Integer> marks2 = new Random().ints(20, 1, 6).boxed().collect(Collectors.toList());

        marks2.forEach(m -> System.out.print(m + ", "));
        System.out.println();
        marks2 = marks2.stream().filter(m -> m > 3).collect(Collectors.toList());
        marks2.forEach(m -> System.out.print(m + ", "));
        System.out.println("\n");


        List<Integer> mark3 = new Random().ints(20, 1, 11).boxed().collect(Collectors.toList());
        mark3.forEach(m -> System.out.print(m + ", "));
        System.out.println();
        mark3.removeIf(m -> m < 5);
        mark3.forEach(m -> System.out.print(m + ", "));

    }
}
