package org.example.lesson9collections;

import java.util.Scanner;

public class TextScanner {
    private static final String MESSAGE = "Enter text or :exit to complete entry";
    private static final String ERROR_MESSAGE = "The text must not be empty!";
    private static final String EXIT_CODE = ":exit";

    public static String getText() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        System.out.println(MESSAGE);
        while (true) {
            String text = scanner.nextLine();
            if (text.equals(EXIT_CODE) && builder.length() == 0) {
                System.out.println(ERROR_MESSAGE);
            } else if (builder.length() != 0 && text.equals(EXIT_CODE)) {
                return builder.toString();
            } else if (!text.isEmpty()) {
                builder.append(text).append('\n');
            } else {
                System.out.println(MESSAGE);
            }
        }
    }
}
