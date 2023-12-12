package org.example.lesson5classes.atm;

public enum Cash {
    DENOMINATION_20(0, 20), DENOMINATION_50(1, 50), DENOMINATION_100(2, 100);
    final int denIndex;
    final int value;

    Cash(int denIndex, int value) {
        this.denIndex = denIndex;
        this.value = value;
    }

    public static Cash getDenominationByIndex(int denIndex) {
        return Cash.values()[denIndex];
    }
}
