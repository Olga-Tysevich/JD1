package org.example.lesson3operators;

import java.time.DateTimeException;

public class CustomDate {
    private final int day;
    private final int month;
    private final int year;

    public CustomDate(int day, int month, int year) {
        if (year > 0 && month > 0 && month < 13 && checkDay(day, month, year)) {
            this.year = year;
            this.day = day;
            this.month = month;
        } else if (year <= 0) {
            throw new DateTimeException("Incorrect year specified!");
        } else if (month <= 0) {
            throw new DateTimeException("Incorrect month specified!");
        } else {
            throw new DateTimeException("Incorrect day specified!");
        }
    }

    public void printNextDay() {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> changeDay(31);
            case 2 -> {
                if (isLeapYear(year)) {
                    changeDay(29);
                } else {
                    changeDay(28);
                }
            }
            case 4, 6, 9, 11 -> changeDay(30);
        }
    }

    private void changeDay(int lastDayOfMonth) {
        int day = this.day, month = this.month, year = this.year;
        if (day == lastDayOfMonth && month != 12) {
            String sMonth = ++month ==1 ? "01" : String.valueOf(++month);
            System.out.println("01." + sMonth + "." + year);
        } else if (day == lastDayOfMonth) {
            System.out.println("01.01." + ++year);
        } else {
            System.out.println(++day + "." + month + "." + year);
        }
    }

    private boolean checkDay(int day, int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day > 0 && day <= 31;
            }
            case 2 -> {
                if (isLeapYear(year)) {
                    return day > 0 && day <= 29;
                } else {
                    return day > 0 && day <= 28;
                }
            }
            case 4, 6, 9, 11 -> {
                return day > 0 && day <= 30;
            }
            default -> {
                return false;
            }
        }
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }
}
