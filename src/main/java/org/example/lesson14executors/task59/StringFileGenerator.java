package org.example.lesson14executors.task59;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.example.lesson14executors.task59.Constants.*;

/*Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками, засыпает произвольно на 1-3 секунды,
 * результат выполнения - коллекция имен файлов. Запустить 10 задач параллельно в пуле из 3 потоков.
 * Вывести ход программы на экран с указанием имени потока, который выполняет работу*/
public class StringFileGenerator implements Callable<List<String>> {
    @Override
    public List<String> call() throws InterruptedException {
        List<String> fileNames = Stream.generate(() ->
                        new File(OUT_DIRECTORY + OUT_FILE_NAME.replace(THREAD_NAME_MARKER, Thread.currentThread().getName())
                                .replace(FILE_NUMBER_MARKER, String.valueOf(new Random().nextInt()))))
                .limit(NUMBER_OF_FILES)
                .peek(this::writeFile)
                .map(File::getName)
                .toList();
        Thread.sleep(new Random().nextInt(MAX_SLEEP_TIME) + 1000);
        return fileNames;
    }

    private void writeFile(File file) {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            IntStream.range(0, NUMBER_OF_STRINGS)
                    .mapToObj(n -> "String-" + new Random().nextInt())
                    .peek(printWriter::println)
                    .forEach(s -> System.out.println(Thread.currentThread().getName() + " wrote:" + s + " to file:" + file.getName()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
