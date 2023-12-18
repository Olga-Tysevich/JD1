package org.example.verified.lesson5classes.atm;

public enum Cash {
    DENOMINATION_20(0, 20), DENOMINATION_50(1, 50), DENOMINATION_100(2, 100);
    private int denIndex;
    private int value;

    Cash(int denIndex, int value) {
        this.denIndex = denIndex;
        this.value = value;
    }

    public static Cash getDenominationByIndex(int denIndex) {
        return Cash.values()[denIndex];
    }

    public int getValue() {
        return value;
    }
}
