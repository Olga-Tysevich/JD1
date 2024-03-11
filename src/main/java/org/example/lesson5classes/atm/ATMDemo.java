package org.example.lesson5classes.atm;


import java.util.Random;

public class ATMDemo {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ATM atm1 = new ATM(11,12,1);

        System.out.println(atm1.withdrawMoney(170));
        ATM atm3 =  new ATM(20,10,20);
        try {
            atm3 = new ATM(-1, 0, 5);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

       for (int i = 0; i < 1000; i += 10) {
           atm1.addMoney(Cash.DENOMINATION_20, RANDOM.nextInt(15));
           atm1.addMoney(Cash.DENOMINATION_50, RANDOM.nextInt(20));
           atm1.addMoney(Cash.DENOMINATION_100, RANDOM.nextInt(12));

           System.out.println("sum: " + i + " result: " + atm1.withdrawMoney(i) + "\n");

           atm1.clean();
       }
    }
}
