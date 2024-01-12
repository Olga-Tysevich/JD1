package org.example.lesson9collections;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        //Создать коллекцию, заполнить ее случайными числами. Удалить повторяющиеся
        Collection<Integer> collection = new Random().ints(20, 1, 21).boxed().collect(Collectors.toList());
        collection.forEach(n -> System.out.print(n + ", "));
        Collection<Integer> filteredCollection1 = new ArrayList<>();
        for (Integer number : collection) {
            if (!filteredCollection1.contains(number)) {
                filteredCollection1.add(number);
            }
        }
        System.out.println();
        filteredCollection1.forEach(n -> System.out.print(n + ", "));
        System.out.println('\n');


        Collection<Integer> collection2 = new Random().ints(20, 1, 21).boxed()
                                                .collect(Collectors.toCollection(LinkedList::new));
        collection2.forEach(n -> System.out.print(n + ", "));
        System.out.println();
        new LinkedHashSet<>(collection2).forEach(n -> System.out.print(n + ", "));
        System.out.println('\n');


        Collection<Integer> collection3 = new Random().ints(20, 1, 21).boxed()
                                    .collect(Collectors.toCollection(LinkedList::new));
        collection3.forEach(n -> System.out.print(n + ", "));
        System.out.println();
        collection3.stream().distinct().collect(Collectors.toList()).forEach(n -> System.out.print(n + ", "));
    }
}
