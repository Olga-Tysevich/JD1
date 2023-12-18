package org.example.lesson7inheritance.appliances.watch;

import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class WeatherStation extends AlarmClock{
    private boolean hasRemoteSensor;

    public WeatherStation(AppliancesCategory category, String brand, double price, AlarmClockType type, boolean hasRemoteSensor) {
        super(category, brand, price, type);
        this.hasRemoteSensor = hasRemoteSensor;
    }

    public boolean isHasRemoteSensor() {
        return hasRemoteSensor;
    }

    public void setHasRemoteSensor(boolean hasRemoteSensor) {
        this.hasRemoteSensor = hasRemoteSensor;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasRemoteSensor=" + hasRemoteSensor;
    }
}
