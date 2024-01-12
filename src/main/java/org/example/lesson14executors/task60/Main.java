package org.example.lesson14executors.task60;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.example.lesson14executors.task60.Constants.NUMBER_OF_TASKS;
import static org.example.lesson14executors.task60.Constants.NUMBER_OF_THREADS;

public class Main {
    public static void main(String[] args) {
        /*Создать задачу Callable, которая генерирует коллекцию из 10 рандомных целых чисел, засыпает произвольно на 1-10 секунд,
         * результат выполнения - сумма этих чисел в виде строки. Запустить 10 задач параллельно в пуле из 3 потоков.
         * Вывести ход программы на экран с указанием имени потока, который выполняет работу*/
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        List<Future<String>> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            strings.add(service.submit(new Generator()));
        }
        service.shutdown();

        try {
            for (Future<String> f : strings) {
                System.out.print("sum: " + f.get() + ", ");
            }
            System.out.println("\nSize: " + strings.size());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
