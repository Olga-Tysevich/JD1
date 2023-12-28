package org.example.lesson16date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MonthDemo {
    private static final String DATE_PATTERN = "d::MMM::uuuu";
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int MIN_MONTH_NUMBER = 1;
    private static final int MAX_MONTH_NUMBER = 12;

    public static void main(String[] args) {
        /*Ввести с клавиатуры номер месяца текущего года.
        Вывести на экран все его даты в формате d::MMM::uuuu*/
       printAllDateOfMonth();
    }

    public static void printAllDateOfMonth() {
        int monthNumber = getMonthNumber();
        LocalDate date = LocalDate.now().withMonth(monthNumber).withDayOfMonth(FIRST_DAY_OF_MONTH);
        do {
            System.out.println(date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
            date = date.plusDays(1);
        } while (date.getMonth().getValue() == monthNumber);
    }

    private static int getMonthNumber() {
        Scanner scanner = new Scanner(System.in);
        int monthNumber;
        do {
            System.out.println("Input month number: ");
            monthNumber = scanner.hasNextInt() ? scanner.nextInt() : -1;
            scanner.nextLine();
        } while (monthNumber < MIN_MONTH_NUMBER || monthNumber > MAX_MONTH_NUMBER);

        return monthNumber;
    }
}
