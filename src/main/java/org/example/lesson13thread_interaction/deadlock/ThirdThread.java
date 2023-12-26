package org.example.lesson13thread_interaction.deadlock;

public class ThirdThread extends Thread{
    Resources resources;

    public ThirdThread(Resources resources) {
        super("ThirdThread");
        this.resources = resources;
    }

    @Override
    public void run() {
        synchronized (resources.getThird()) {
            System.out.println(Thread.currentThread().getName() + " received: " + resources.getThird());
            synchronized (resources.getFirst()) {
                System.out.println(Thread.currentThread().getName() + " received: " + resources.getFirst());
                synchronized (resources.getFirst()) {
                    System.out.println(Thread.currentThread().getName() + " received: " + resources.getThird());
                }
            }
        }
    }
}
