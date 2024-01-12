package org.example.lesson17solid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateSingleton {
    private static DateSingleton instance;
    private static final String DATE_PATTERN = "dd.MM.uuuu";

    private DateSingleton() {
    }

    public static DateSingleton getDateSingleton() {
        if (instance == null) {
            instance = new DateSingleton();
        }
        return instance;
    }

    public void printCurrentDate() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
    }
}
