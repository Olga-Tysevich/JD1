package org.example.lesson13thread_interaction.producer_consumer;

import java.util.Random;

public class Producer extends Thread {
    private Store store;

    public Producer(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        boolean isFinished;
        do {
            isFinished = store.put();
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!isFinished);
    }
}
