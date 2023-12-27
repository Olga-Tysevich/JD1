package org.example.lesson14executors.task61;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Writer {
    private static final String OUT_FILE_PATH = "src/main/java/org/example/lesson14executors/task61/file.txt";
    public static final int NUMBER_OF_TASKS = 10;
    public static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        /*Создать задачу Callable, которая берет сообщение "Hello world" + текущее время и записывает его в файл.
         * Запись в файл должна производиться последовательно через синхронизированный метод.
         * Запустить 10 задач параллельно в пуле из 3 потоков.
         * Вывести ход программы на экран с указанием имени потока, который выполняет работу*/
        Writer writer = new Writer();

        try (ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                writer.writeToFile(service.submit(() -> {
                    String str = "Hello world " + LocalTime.now();
                    System.out.println(Thread.currentThread().getName() + " write string: " + str);
                    return str;
                }).get());
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeToFile(String string) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUT_FILE_PATH, true))) {
            writer.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
