package org.example.lesson7inheritance.appliances.cleaners;

import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class RobotVacuumCleaner extends VacuumCleaner{
    private int batteryCapacity;

    public RobotVacuumCleaner(AppliancesCategory category, String brand, double price, String dustContainerType, int batteryCapacity) {
        super(category, brand, price, dustContainerType);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +", batteryCapacity=" + batteryCapacity;
    }
}
