package org.example.lesson13thread_interaction.deadlock;

public class DeadlockDemo {
    public static void main(String[] args) {
        /*Создать программу, которая реализует Deadlock между тремя потоками*/
        Collage collage = new Collage();
        FirstThread firstThread = new FirstThread(collage);
        SecondThread secondThread = new SecondThread(collage);
        ThirdThread thirdThread = new ThirdThread(collage);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
