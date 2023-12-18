package org.example.lesson7inheritance.cards;

import java.math.BigDecimal;
import java.time.LocalDate;

/*Создать цепочку наследования банковских карт*/
public class BankCard {
    private String cardOwner;
    private final String cardAccount;
    private final String cardNumber;
    private int pin;
    private final LocalDate expirationDate;
    private BigDecimal amount;

    public BankCard(String cardOwner, String cardAccount, String cardNumber, LocalDate expirationDate, BigDecimal amount) {
        boolean checkData = amount != null && cardOwner != null && cardAccount != null && cardNumber != null
                && expirationDate.isAfter(LocalDate.now());
        if (checkData) {
            this.cardOwner = cardOwner;
            this.cardAccount = cardAccount;
            this.cardNumber = cardNumber;
            this.expirationDate = expirationDate;
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    public void setPin(int oldPin, int newPin) {
        if (this.pin == 0 || this.pin == newPin) {
            this.pin = newPin;
        }
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public String getCardAccount() {
        return cardAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }
}
