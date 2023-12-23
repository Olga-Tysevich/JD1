package org.example.lesson13thread_interaction.deadlock;

public class SecondThread extends Thread{
    Collage collage;

    public SecondThread(Collage collage) {
        super("SecondThread");
        this.collage = collage;
    }

    @Override
    public void run() {
        synchronized (collage.getGlue()) {
            System.out.println(Thread.currentThread().getName() + " took: " + collage.getGlue());
            synchronized (collage.getColorPaper()) {
                System.out.println(Thread.currentThread().getName() + " took: " + collage.getColorPaper());
                synchronized (collage.getScissors()) {
                    System.out.println(Thread.currentThread().getName() + " took: " + collage.getScissors());
                }
            }
        }
    }
}
