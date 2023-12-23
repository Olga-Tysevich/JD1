package org.example.lesson13thread_interaction.producer_consumer;

import java.util.Random;

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
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!isFinished);
    }
}
