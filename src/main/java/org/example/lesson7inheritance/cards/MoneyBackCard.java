package org.example.lesson7inheritance.cards;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MoneyBackCard extends BankCard{
    private int moneyBack;

    public MoneyBackCard(String cardOwner, String cardAccount, String cardNumber, LocalDate expirationDate, BigDecimal amount, int moneyBack) {
        super(cardOwner, cardAccount, cardNumber, expirationDate, amount);
        this.moneyBack = moneyBack;
    }

    public int getMoneyBack() {
        return moneyBack;
    }

    public void setMoneyBack(int moneyBack) {
        this.moneyBack = moneyBack;
    }
}
