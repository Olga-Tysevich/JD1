package org.example.lesson11files.service;

import java.io.*;
import java.util.*;

import static org.example.lesson11files.service.ServiceConstants.ERROR_MESSAGE;

public class DirectoryManager {

    public List<String> getDirectoriesList(String directoryName) throws IOException {
        return getContent(directoryName).stream().filter(File::isDirectory).map(File::getName).toList();
    }

    public List<String> getFilesList(String directoryName) throws IOException {
        return getContent(directoryName).stream().filter(File::isFile).map(File::getName).toList();
    }

    private List<File> getContent(String directoryName) throws IOException {
        File directory = new File(directoryName);
        if (directory.exists()) {
            return Arrays.stream(Objects.requireNonNull(directory.listFiles())).toList();
        } else {
            throw new IOException(ERROR_MESSAGE);
        }
    }
}
