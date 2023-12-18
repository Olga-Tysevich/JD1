package org.example.verified.lesson5classes.atm;

import java.util.Scanner;

public class InputController {
    public int getWithdrawalAmount(int maxAmount) {
        int withdrawalAmount = 0;
        Scanner scanner;
        while (true) {
            System.out.println("Enter amount: ");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                withdrawalAmount = scanner.nextInt();
            }
            if (withdrawalAmount > maxAmount) {
                System.out.println("There is not enough money in the ATM!");
            } else if (checkAmount(withdrawalAmount)) {
                return withdrawalAmount;
            } else {
                System.out.println("Incorrect amount!");
            }
        }
    }

    private boolean checkAmount(int amount) {
        if (amount != 0) {
            Cash[] cash = Cash.values();
            for (int i = 0; i < cash.length; i++) {
                for (int j = cash.length - 1; j > i; j--) {
                    if (amount % cash[i].getValue() == 0 || amount % 100 == cash[i].getValue() || amount % 100 == (cash[i].getValue() + cash[j].getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
