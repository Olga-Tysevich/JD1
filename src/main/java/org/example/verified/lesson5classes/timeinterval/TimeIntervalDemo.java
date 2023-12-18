package org.example.verified.lesson5classes.timeinterval;

public class TimeIntervalDemo {
    public static void main(String[] args) {
        TimeInterval timeInterval1 = new TimeInterval(3700);
        TimeInterval timeInterval2 = new TimeInterval(40,1,1);
        TimeInterval timeInterval3;
        try {
            timeInterval3  = new TimeInterval(1, -1,2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        timeInterval3 = new TimeInterval(4701);
        System.out.println(timeInterval1);
        System.out.println(timeInterval2);
        System.out.println(timeInterval3);

        if (timeInterval1.compareTo(timeInterval2) > 0){
            System.out.println("timeInterval1 is greater than timeInterval2");
        } else if (timeInterval1.compareTo(timeInterval2) == 0) {
            System.out.println("timeInterval1 is equal to timeInterval2");
        } else {
            System.out.println("timeInterval1 is less than timeInterval2");
        }

        if (timeInterval1.compareTo(timeInterval3) > 0){
            System.out.println("timeInterval1 is greater than timeInterval3");
        } else if (timeInterval1.compareTo(timeInterval3) == 0) {
            System.out.println("timeInterval1 is equal to timeInterval3");
        } else {
            System.out.println("timeInterval1 is less than timeInterval3");
        }

        System.out.println("timeInterval1 in seconds: " + timeInterval1.getTimeInSecond());
        System.out.println("timeInterval2 in seconds: " + timeInterval2.getTimeInSecond());
        System.out.println("timeInterval3 in seconds: " + timeInterval3.getTimeInSecond());
    }
}
