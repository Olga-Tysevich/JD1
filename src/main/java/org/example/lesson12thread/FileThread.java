package org.example.lesson12thread;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileThread extends Thread {
    private int[] randomArray;
    private int arraySize;
    private String outFilePath;

    public FileThread(int arraySize, String outFilePath) {
        this.arraySize = arraySize;
        this.outFilePath = outFilePath;
    }

    @Override
    public void run() {
        randomArray = new Random().ints(arraySize, 0, 101).toArray();
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(outFilePath, true))) {
            for (int n : randomArray) {
                writer.println(n);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
