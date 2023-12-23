package org.example.lesson13thread_interaction;

public class PrintThread implements Runnable {
    @Override
    public void run() {
        printThreadName();
    }

    private synchronized void printThreadName() {
        System.out.println(Thread.currentThread().getName() + " started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " has been interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }

    public static void main(String[] args) {
        /*Создать метод, который печатает название потока и засыпает на 2 секунды.
         * Запустить 10 потоков. Реализовать механизм синхронизации, чтобы все потоки выполнились последовательно*/
        PrintThread printThread = new PrintThread();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(printThread);
            t.start();
        }
    }

}
