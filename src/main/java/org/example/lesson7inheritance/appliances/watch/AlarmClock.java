package org.example.lesson7inheritance.appliances.watch;

import org.example.lesson7inheritance.appliances.Appliance;
import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class AlarmClock extends Appliance {
    private AlarmClockType type;

    public AlarmClock(AppliancesCategory category, String brand, double price, AlarmClockType type) {
        super(category, brand, price);
        this.type = type;
    }

    public AlarmClockType getType() {
        return type;
    }

    public void setType(AlarmClockType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", type=" + type;
    }
}
