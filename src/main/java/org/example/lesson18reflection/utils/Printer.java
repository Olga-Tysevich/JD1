package org.example.lesson18reflection.utils;

import org.example.lesson18reflection.annotation.AcademyInfo;

public abstract class Printer {
    public static void printHelloWorld(){
        System.out.println("Hello world");
    }

    @AcademyInfo(year = 2024)
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
