package org.example.lesson7inheritance.appliances.watch;

import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class LightAlarmClock extends AlarmClock{
    private int lightIntensity;

    public LightAlarmClock(AppliancesCategory category, String brand, double price, AlarmClockType type, int lightIntensity) {
        super(category, brand, price, type);
        this.lightIntensity = lightIntensity;
    }

    public int getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(int lightIntensity) {
        this.lightIntensity = lightIntensity;
    }
    @Override
    public String toString() {
        return super.toString() +  ", lightIntensity=" + lightIntensity;
    }
}
