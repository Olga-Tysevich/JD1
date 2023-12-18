package org.example.lesson7inheritance.appliances.kitchen;

import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class CarRefrigerator extends Fridge{
    private String thermalInsulation;

    public CarRefrigerator(AppliancesCategory category, String brand, double price, int totalUsableVolume, String thermalInsulation) {
        super(category, brand, price, totalUsableVolume);
        this.thermalInsulation = thermalInsulation;
    }

    public String getThermalInsulation() {
        return thermalInsulation;
    }

    public void setThermalInsulation(String thermalInsulation) {
        this.thermalInsulation = thermalInsulation;
    }

    @Override
    public String toString() {
        return super.toString() + ", thermalInsulation='" + thermalInsulation;
    }
}
