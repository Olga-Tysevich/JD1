package org.example.lesson7inheritance.cards;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusCard extends BankCard{
    private String bonusProgram;
    private int bonusPoints;

    public BonusCard(String cardOwner, String cardAccount, String cardNumber, LocalDate expirationDate, BigDecimal amount) {
        super(cardOwner, cardAccount, cardNumber, expirationDate, amount);
    }

    public String getBonusProgram() {
        return bonusProgram;
    }

    public void setBonusProgram(String bonusProgram) {
        this.bonusProgram = bonusProgram;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}
