package org.example.lesson13thread_interaction.deadlock;

public class FirstThread extends Thread{
    Collage collage;

    public FirstThread(Collage collage) {
        super("FirstThread");
        this.collage = collage;
    }

    @Override
    public void run() {
        synchronized (collage.getColorPaper()) {
            System.out.println(Thread.currentThread().getName() + " took: " + collage.getColorPaper());
            synchronized (collage.getGlue()) {
                System.out.println(Thread.currentThread().getName()  + " took: " + collage.getGlue());
                synchronized (collage.getScissors()) {
                    System.out.println(Thread.currentThread().getName() + " took: " + collage.getScissors());
                }
            }
        }
    }
}
