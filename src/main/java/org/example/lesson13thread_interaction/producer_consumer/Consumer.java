package org.example.lesson13thread_interaction.producer_consumer;

import java.util.Random;

import static org.example.lesson13thread_interaction.producer_consumer.Constants.MAX_SLEEP_TIME;

public class Consumer extends Thread {
    private Store store;

    public Consumer(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        boolean isFinished;
        do {
            isFinished = store.get();
            try {
                Thread.sleep(new Random().nextInt(MAX_SLEEP_TIME));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!isFinished);
    }
}
