package org.example.verified.lesson5classes.atm;


public class ATMDemo {
    public static void main(String[] args) {
        ATM atm1 = new ATM(1,10,20);
        ATM atm3 =  new ATM(20,10,20);
        try {
            atm3 = new ATM(-1, 0, 5);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println(atm1.withdrawMoney());
        System.out.println(atm3.withdrawMoney());
        atm1.addMoney(Cash.DENOMINATION_20, 15);
        System.out.println(atm1.withdrawMoney());
    }
}
