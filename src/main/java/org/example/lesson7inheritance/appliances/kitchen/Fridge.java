package org.example.lesson7inheritance.appliances.kitchen;

import org.example.lesson7inheritance.appliances.Appliances;
import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class Fridge extends Appliances {
    private int totalUsableVolume;

    public Fridge(AppliancesCategory category, String brand, double price, int totalUsableVolume) {
        super(category, brand, price);
        this.totalUsableVolume = totalUsableVolume;
    }

    public int getTotalUsableVolume() {
        return totalUsableVolume;
    }

    public void setTotalUsableVolume(int totalUsableVolume) {
        this.totalUsableVolume = totalUsableVolume;
    }

    @Override
    public String toString() {
        return super.toString() +  ", totalUsableVolume=" + totalUsableVolume;
    }
}
