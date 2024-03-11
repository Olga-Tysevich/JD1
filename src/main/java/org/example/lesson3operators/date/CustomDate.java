package org.example.lesson3operators.date;

import java.time.DateTimeException;

import static org.example.lesson3operators.date.Constants.*;

public class CustomDate {
    private final int day;
    private final int month;
    private final int year;

    public CustomDate(int day, int month, int year) {
        if (year > 0 && month >= FIRST_MONTH_OF_YEAR && month <= LAST_MONTH_OF_YEAR && checkDay(day, month, year)) {
            this.year = year;
            this.day = day;
            this.month = month;
        } else if (year <= 0) {
            throw new DateTimeException(INVALID_YEAR_MESSAGE);
        } else if (month <= 0) {
            throw new DateTimeException(INVALID_MONTH_MESSAGE);
        } else {
            throw new DateTimeException(INVALID_DAY_MESSAGE);
        }
    }

    public void printNextDay() {

        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                changeDay(LAST_DAY_OF_MONTH_31); break;
            case FEBRUARY: {
                if (isLeapYear(year)) {
                    changeDay(LAST_DAY_OF_FEBRUARY_LEAP_YEAR);
                } else {
                    changeDay(LAST_DAY_OF_FEBRUARY);
                }
                break;
            }
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                changeDay(LAST_DAY_OF_MONTH_30); break;
        }
    }

    private void changeDay(int lastDayOfMonth) {
        int day = this.day, month = this.month, year = this.year;
        if (day == lastDayOfMonth && month != LAST_MONTH_OF_YEAR) {
            day = FIRST_DAY_OF_MONTH;
            month++;
        } else if (day == lastDayOfMonth) {
            day = FIRST_DAY_OF_MONTH;
            month = FIRST_MONTH_OF_YEAR;
            year++;
        } else {
            day++;
        }
        System.out.printf(DATE_PATTERN, day, month, year);
    }

    private boolean checkDay(int day, int month, int year) {
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_MONTH_31;
            case FEBRUARY: {
                if (isLeapYear(year)) {
                    return day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_FEBRUARY_LEAP_YEAR;
                } else {
                    return day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_FEBRUARY;
                }
            }
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return day > FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_MONTH_30;
            default:
                return false;
        }
    }

    private boolean isLeapYear(int year) {
        if (year % DIVISOR_LEAP_YEAR_400 == 0) {
            return true;
        } else if (year % DIVISOR_LEAP_YEAR_100 == 0) {
            return false;
        } else {
            return year % DIVISOR_LEAP_YEAR_4 == 0;
        }
    }
}
