package org.example.lesson12thread;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static final int LIST_SIZE = 10;
    public static final int ARRAY_SIZE = 10;
    public static final String OUT_FILE_PATH = "src/main/java/org/example/lesson12thread/file.txt";

    public static void main(String[] args) {
        /*Создать 10 потоков, каждый из которых вычисляет среднее арифметическое
        коллекции из 10 случайных целых чисел и выводит на экран*/
        List<Integer> numbers;
        for (int i = 0; i < 10; i++) {
            numbers = new Random().ints(LIST_SIZE, 0, 101).boxed().collect(Collectors.toList());
            AverageThread averageThread = new AverageThread(numbers);
            averageThread.start();
        }

        /*Создать класс поток, который генерирует массив случайных целых чисел из 10 элементов,
         * затем находит максимальный элемент, и выводит на экран в формате имя потока, максимальный элемент.
         * Запустить 10 потоков*/
        for (int i = 0; i < 10; i++) {
            new MaxThread(ARRAY_SIZE).start();
        }

        /*Создать класс поток, который создает средствами Java файл и записать в него произвольно сгенерированный
         * массив из 10 случайных чисел. Запустить 5 потоков*/
        for (int i = 0; i < 5; i++) {
            new FileThread(ARRAY_SIZE, OUT_FILE_PATH).start();
        }
    }
}
