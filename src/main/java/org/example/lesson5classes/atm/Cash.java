package org.example.lesson5classes.atm;

public enum Cash {
    DENOMINATION_100(100), DENOMINATION_50(50),DENOMINATION_20(20);
    private int value;

    Cash(int value) {
        this.value = value;
    }

    public static Cash getDenominationByIndex(int denIndex) {
        return Cash.values()[denIndex];
    }

    public int getValue() {
        return value;
    }



}
