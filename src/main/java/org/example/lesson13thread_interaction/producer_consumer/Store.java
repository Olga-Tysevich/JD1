package org.example.lesson13thread_interaction.producer_consumer;

import java.util.*;

import static org.example.lesson13thread_interaction.producer_consumer.Constants.*;

public class Store {
    /*Есть 3 производителя и 2 потребителя, все разные потоки и работают одновременно.
     * Есть очередь с 200 элементами. Производители добавляют случайное число от 1 до 100,
     * потребители берут эти числа. Если в очереди элементов >= 100 производители спят, если нет элементов -
     * потребители спят. Если элементов стало <= 80, производители просыпаются. Все это работает пока
     * обработанных элементов не станет 10_000, только потом программа завершается*/
    private final Queue<Integer> store = new ArrayDeque<>();
    private int itemsCounter;

    public Store() {
        for (int i = 0; i < INITIAL_SIZE; i++) {
            store.offer(new Random().nextInt(MAX_RANDOM_NUMBER) + 1);
        }
    }

    public boolean put() {
        synchronized (store) {
            while (store.size() >= MAX_ELEMENTS_TO_ADD) {
                try {
                    store.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (itemsCounter < MAX_PROCESSED_ELEMENTS) {
                int item = new Random().nextInt(MAX_RANDOM_NUMBER) + 1;
                store.offer(item);
                System.out.println(Thread.currentThread().getName() + " put item: " + item + " , store size: " + store.size());
                store.notifyAll();
            }
            return itemsCounter >= MAX_PROCESSED_ELEMENTS;
        }
    }

    public boolean get() {
        synchronized (store) {
            while (store.size() == 0) {
                try {
                    store.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (itemsCounter < MAX_PROCESSED_ELEMENTS) {
                itemsCounter++;
                int item = store.remove();
                System.out.println(Thread.currentThread().getName() + " get item: " + item + " , store size: " + store.size());
                if (store.size() <= MIN_ELEMENTS_IN_QUEUE || itemsCounter == MAX_PROCESSED_ELEMENTS) {
                    store.notifyAll();
                    System.out.println(itemsCounter);
                }
            }
            return itemsCounter == MAX_PROCESSED_ELEMENTS;
        }
    }
}
