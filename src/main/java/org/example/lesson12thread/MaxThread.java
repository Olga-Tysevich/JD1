package org.example.lesson12thread;

import java.util.Arrays;
import java.util.Random;

public class MaxThread extends Thread{
    private int[] intArray;
    private int arraySize;

    public MaxThread(int arraySize) {
        this.arraySize = arraySize;
    }

    @Override
    public void run() {
        intArray = new Random().ints(arraySize, 0, 101).toArray();
        System.out.println(Thread.currentThread().getName() + ": " + Arrays.toString(intArray)
                + ", max: " + Arrays.stream(intArray).max().orElse(-1));
    }
}
