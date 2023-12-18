package org.example.fixed.lesson3operators.date;

import java.time.DateTimeException;

import static org.example.fixed.lesson3operators.date.Constants.*;

public class CustomDate {
    private final int day;
    private final int month;
    private final int year;

    public CustomDate(int day, int month, int year) {
        if (year > 0 && month > 0 && month <= MONTH_IN_YEAR && checkDay(day, month, year)) {
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
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> changeDay(31);
            case FEBRUARY -> {
                if (isLeapYear(year)) {
                    changeDay(29);
                } else {
                    changeDay(28);
                }
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> changeDay(30);
        }
    }

    private void changeDay(int lastDayOfMonth) {
        int day = this.day, month = this.month, year = this.year;
        if (day == lastDayOfMonth && month != MONTH_IN_YEAR) {
            day = 1;
            month++;
        } else if (day == lastDayOfMonth) {
            day = 1;
            month = 1;
            year++;
        } else {
           day++;
        }
        System.out.printf("%02d.%02d.%d", day, month, year);
    }

    private boolean checkDay(int day, int month, int year) {
        switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
                return day > 0 && day <= 31;
            }
            case FEBRUARY -> {
                if (isLeapYear(year)) {
                    return day > 0 && day <= 29;
                } else {
                    return day > 0 && day <= 28;
                }
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
                return day > 0 && day <= 30;
            }
            default -> {
                return false;
            }
        }
    }

    private boolean isLeapYear(int year) {
        if (year % FIST_DIVISOR_DETERMINING_LEAP_YEAR == 0) {
            return true;
        } else if (year % SECOND_DIVISOR_DETERMINING_LEAP_YEAR == 0) {
            return false;
        } else {
            return year % THIRD_DIVISOR_DETERMINING_LEAP_YEAR == 0;
        }
    }
}
