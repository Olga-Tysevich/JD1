package org.example.lesson13thread_interaction.deadlock;

public class DeadlockDemo {
    public static void main(String[] args) {
        /*Создать программу, которая реализует Deadlock между тремя потоками*/
        Resources resources = new Resources();
        FirstThread firstThread = new FirstThread(resources);
        SecondThread secondThread = new SecondThread(resources);
        ThirdThread thirdThread = new ThirdThread(resources);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
