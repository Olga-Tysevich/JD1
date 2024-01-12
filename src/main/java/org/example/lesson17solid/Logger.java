package org.example.lesson17solid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static volatile Logger instance;
    private static final String LINE_SEPARATOR = "\n";
    private static final String TEXT_BEFORE_MESSAGE = ", error: ";
    private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";
    private final File LOG;


    private Logger(String logPath) {
        this.LOG = new File(logPath);
    }

    public boolean logErrorMessages(String errorMessage) {
        synchronized (LOG) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG, true))) {
                writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)) + TEXT_BEFORE_MESSAGE + errorMessage + LINE_SEPARATOR);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
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
