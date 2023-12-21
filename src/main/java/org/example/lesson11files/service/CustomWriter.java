package org.example.lesson11files.service;

import java.io.*;
import java.util.List;

public class CustomWriter {
    public <T> boolean writeToFile(List<T> data, String outFilePath, boolean append) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outFilePath, append))) {
            for (T o : data) {
                writer.println(o);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean writeIntToBinaryFile(List<Integer> number, String outFilePath, boolean append) {
        try (DataOutputStream outputStream = new DataOutputStream
                (new BufferedOutputStream(new FileOutputStream(outFilePath, append)))) {
            for (int n : number) {
                outputStream.writeInt(n);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public <T extends Serializable> boolean writeObject(List<T> objects, String outFilePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(outFilePath))) {
            for (T o : objects) {
                outputStream.writeObject(o);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
