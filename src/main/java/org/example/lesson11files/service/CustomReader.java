package org.example.lesson11files.service;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomReader {

    public List<String> readFile(File file) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings;
    }

    public List<Integer> readIntFromBinaryFile(String inFilePath) {
        List<Integer> result = new LinkedList<>();
        try (DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(inFilePath)))) {
            while (true) {
                try {
                    result.add(inputStream.readInt());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Object> readObject(String inFilePath) {
        List<Object> objects = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(inFilePath))) {
            while (true) {
                try {
                    objects.add(inputStream.readObject());
                } catch (ClassNotFoundException | EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return objects;
    }
}
