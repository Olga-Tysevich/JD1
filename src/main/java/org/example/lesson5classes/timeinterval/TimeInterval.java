package org.example.lesson5classes.timeinterval;

/*Создать класс описывающий промежуток времени. Сам промежуток должен задаваться тремя св-ми:
 * сек, мин, часы. Сделать методы для получения полного кол-ва секунд, сравнения двух объектов.
 * создать два конструктора (общее кол сек, второй - часы, мин, сек по отдельности.
 * Сделать метод для вывода данных */
public class TimeInterval implements Comparable<TimeInterval>{
    private final int sec;
    private final int min;
    private final int hours;

    public TimeInterval(int sec) {
        if (sec >= 0) {
            this.sec = sec % 60;
            int m = (sec - this.sec) / 60;
            this.min = m % 60;
            this.hours = (m - this.min) / 60;
        } else {
            throw new IllegalArgumentException("Incorrect seconds value!");
        }
    }

    public TimeInterval(int sec, int min, int hours) {
        if (sec >= 0 && sec < 61 && min >= 0 && min < 61 && hours >= 0 && hours < 25) {
            this.sec = sec;
            this.min = min;
            this.hours = hours;
        } else if (sec < 0 || sec > 61) {
            throw new IllegalArgumentException("Incorrect seconds value!");
        } else if (min < 0 || min > 61) {
            throw new IllegalArgumentException("Incorrect minutes value!");
        } else {
            throw new IllegalArgumentException("Incorrect hours value!");
        }
    }

    public int getTimeInSecond() {
        return sec + min * 60 + hours * 3600;
    }

    @Override
    public String toString() {
        return "TimeInterval {" +
                "sec=" + sec +
                ", min=" + min +
                ", hours=" + hours +
                '}';
    }

    @Override
    public int compareTo(TimeInterval anotherInterval) {
       return sec - anotherInterval.getSec() + min - anotherInterval.getMin() + hours - anotherInterval.getHours();
    }

    public int getSec() {
        return sec;
    }

    public int getMin() {
        return min;
    }

    public int getHours() {
        return hours;
    }
}
