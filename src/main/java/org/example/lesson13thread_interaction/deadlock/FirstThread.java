package org.example.lesson13thread_interaction.deadlock;

public class FirstThread extends Thread{
    Resources resources;

    public FirstThread(Resources resources) {
        super("FirstThread");
        this.resources = resources;
    }

    @Override
    public void run() {
        synchronized (resources.getFirst()) {
            System.out.println(Thread.currentThread().getName() + " received: " + resources.getFirst());
            synchronized (resources.getSecond()) {
                System.out.println(Thread.currentThread().getName()  + " received: " + resources.getSecond());
                synchronized (resources.getThird()) {
                    System.out.println(Thread.currentThread().getName() + " received: " + resources.getThird());
                }
            }
        }
    }
}
