package org.example.lesson9collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        /*Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
        * Найти самую высокую с использованием итератора*/
        List<Integer> marks = new Random().ints(5, 1, 6).boxed().collect(Collectors.toCollection(LinkedList::new));
        marks.forEach(m -> System.out.print(m + ", "));
        Iterator<Integer> iterator = marks.listIterator();
        int max = marks.get(0);
        while (iterator.hasNext()){
            int currentMark = iterator.next();
            if (currentMark > max) {
                max = currentMark;
            }
        }
        System.out.println("\nmax mark: " + max);

        System.out.println("\nmax: " + marks.stream().max(Integer::compareTo).orElse(0));
    }
}
