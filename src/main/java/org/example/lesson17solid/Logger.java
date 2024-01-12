package org.example.lesson17solid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static volatile Logger instance;
    private final File log;

    private Logger(String logPath) {
        this.log = new File(logPath);
    }

    public boolean logBug(String bugMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(log, true))){

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Logger getInstance(String logPath) {
        Logger result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger(logPath);
            }
            return instance;
        }
    }
}
