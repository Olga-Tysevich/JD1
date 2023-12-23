package org.example.lesson13thread_interaction.deadlock;

public class ThirdThread extends Thread{
    Collage collage;

    public ThirdThread(Collage collage) {
        super("ThirdThread");
        this.collage = collage;
    }

    @Override
    public void run() {
        synchronized (collage.getScissors()) {
            System.out.println(Thread.currentThread().getName() + " took: " + collage.getScissors());
            synchronized (collage.getColorPaper()) {
                System.out.println(Thread.currentThread().getName() + " took: " + collage.getColorPaper());
                synchronized (collage.getColorPaper()) {
                    System.out.println(Thread.currentThread().getName() + " took: " + collage.getScissors());
                }
            }
        }
    }
}
