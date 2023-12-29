package org.example.lesson7inheritance.appliances.cleaners;

import org.example.lesson7inheritance.appliances.Appliance;
import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class VacuumCleaner extends Appliance {
    private String dustContainerType;

    public VacuumCleaner(AppliancesCategory category, String brand, double price, String dustContainerType) {
        super(category, brand, price);
        this.dustContainerType = dustContainerType;
    }

    public String getDustContainerType() {
        return dustContainerType;
    }

    public void setDustContainerType(String dustContainerType) {
        this.dustContainerType = dustContainerType;
    }

    @Override
    public String toString() {
        return super.toString() + ", dustContainerType='" + dustContainerType;
    }
}
