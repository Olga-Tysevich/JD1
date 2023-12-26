package org.example.lesson13thread_interaction.producer_consumer;


public class Main {
    public static void main(String[] args) {

        Store store = new Store();
        Producer producer1 = new Producer(store, "Producer-1");
        Producer producer2 = new Producer(store, "Producer-2");
        Producer producer3 = new Producer(store, "Producer-3");

        Consumer consumer1 = new Consumer(store, "Consumer-1");
        Consumer consumer2 = new Consumer(store, "Consumer-2");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
    }
}
