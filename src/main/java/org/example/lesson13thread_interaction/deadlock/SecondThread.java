package org.example.lesson13thread_interaction.deadlock;

public class SecondThread extends Thread{
    Resources resources;

    public SecondThread(Resources resources) {
        super("SecondThread");
        this.resources = resources;
    }

    @Override
    public void run() {
        synchronized (resources.getSecond()) {
            System.out.println(Thread.currentThread().getName() + " received: " + resources.getSecond());
            synchronized (resources.getFirst()) {
                System.out.println(Thread.currentThread().getName() + " received: " + resources.getFirst());
                synchronized (resources.getThird()) {
                    System.out.println(Thread.currentThread().getName() + " received: " + resources.getThird());
                }
            }
        }
    }
}
