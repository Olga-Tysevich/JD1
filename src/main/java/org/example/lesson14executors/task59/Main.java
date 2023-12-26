package org.example.lesson14executors.task59;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.lesson14executors.task59.Constants.*;

public class Main {
    public static void main(String[] args) {
        /*Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками, засыпает произвольно на 1-3 секунды,
        * результат выполнения - коллекция имен файлов. Запустить 10 задач параллельно в пуле из 3 потоков.
        * Вывести ход программы на экран с указанием имени потока, который выполняет работу*/
        System.out.println("Directory created: " + new File(OUT_DIRECTORY).mkdirs());
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        List<String> fileNames = new ArrayList<>();

        try {
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                fileNames.addAll(service.submit(new StringFileGenerator()).get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.close();
        System.out.println("\n" + fileNames + "\n Number of files: " + fileNames.size());
    }
}
