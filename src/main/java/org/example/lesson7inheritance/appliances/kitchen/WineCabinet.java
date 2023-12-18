package org.example.lesson7inheritance.appliances.kitchen;

import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class WineCabinet extends Fridge {
    private int numberBottlePlaces;

    public WineCabinet(AppliancesCategory category, String brand, double price, int totalUsableVolume, int numberBottlePlaces) {
        super(category, brand, price, totalUsableVolume);
        this.numberBottlePlaces = numberBottlePlaces;
    }

    public int getNumberBottlePlaces() {
        return numberBottlePlaces;
    }

    public void setNumberBottlePlaces(int numberBottlePlaces) {
        this.numberBottlePlaces = numberBottlePlaces;
    }

    @Override
    public String toString() {
        return super.toString() + ", numberBottlePlaces=" + numberBottlePlaces;
    }
}
