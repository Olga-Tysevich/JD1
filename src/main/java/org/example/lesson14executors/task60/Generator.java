package org.example.lesson14executors.task60;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

import static org.example.lesson14executors.task60.Constants.*;

/*Создать задачу Callable, которая генерирует коллекцию из 10 рандомных целых чисел, засыпает произвольно на 1-10 секунд,
 * результат выполнения - сумма этих чисел в виде строки. Запустить 10 задач параллельно в пуле из 3 потоков.
 * Вывести ход программы на экран с указанием имени потока, который выполняет работу*/
public class Generator implements Callable<String> {
    @Override
    public String call() {
        String sum = Objects.requireNonNull(Stream.generate(() -> new Random().nextInt(MAX_NUMBER) + 1)
                .limit(AMOUNT_OF_NUMBERS)
                .peek(n -> System.out.println(Thread.currentThread().getName() + " added number: " + n))
                .reduce(Integer::sum).orElse(0)).toString();
        System.out.println(Thread.currentThread().getName() + ", sum: " + sum);
        try {
            Thread.sleep(new Random().nextInt(MAX_SLEEP_TIME) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
