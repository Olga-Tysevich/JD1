package org.example.lesson12thread;

import java.util.List;

public class AverageThread extends Thread {
    private List<Integer> numbers;

    public AverageThread(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":\n" + numbers);
        System.out.println(Thread.currentThread().getName() + ", average: "
                + (double) numbers.stream().reduce(Integer::sum).orElse(-1) / numbers.size());
    }
}
