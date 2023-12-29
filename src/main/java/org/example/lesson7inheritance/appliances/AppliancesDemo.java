package org.example.lesson7inheritance.appliances;

import org.example.lesson7inheritance.appliances.cleaners.RobotVacuumCleaner;
import org.example.lesson7inheritance.appliances.cleaners.VacuumCleaner;
import org.example.lesson7inheritance.appliances.cleaners.VerticalVacuumCleaner;
import org.example.lesson7inheritance.appliances.kitchen.CarRefrigerator;
import org.example.lesson7inheritance.appliances.kitchen.Fridge;
import org.example.lesson7inheritance.appliances.kitchen.WineCabinet;
import org.example.lesson7inheritance.appliances.watch.AlarmClock;
import org.example.lesson7inheritance.appliances.watch.LightAlarmClock;
import org.example.lesson7inheritance.appliances.watch.WeatherStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.lesson7inheritance.appliances.AppliancesCategory.*;
import static org.example.lesson7inheritance.appliances.watch.AlarmClockType.*;

public class AppliancesDemo {
    public static void main(String[] args) {
        /*Создать цепочку наследования классов, описывающих бытовую технику.
         * Создать несколько объектов описанных классов, часть из них включить. Иерархия должна иметь хотя бы 3 уровня*/


        List<Appliance> appliances = new ArrayList<>();

        appliances.add(new Fridge(KITCHEN_APPLIANCES, "LG", 2700, 300));
        appliances.add(new Fridge(KITCHEN_APPLIANCES, "SAMSUNG", 5100, 400));
        appliances.add(new WineCabinet(KITCHEN_APPLIANCES, "LG", 900, 50, 8));
        appliances.add(new WineCabinet(KITCHEN_APPLIANCES, "SAMSUNG", 1200, 60, 10));
        appliances.add(new CarRefrigerator(KITCHEN_APPLIANCES, "Beko", 750, 30, "Foam plastic"));
        appliances.add(new CarRefrigerator(KITCHEN_APPLIANCES, "SAMSUNG", 950, 40, "Foam plastic"));
        appliances.add(new VacuumCleaner(CLEANERS, "LG", 320, "Bag"));
        appliances.add(new VacuumCleaner(CLEANERS, "SAMSUNG", 480, "Container"));
        appliances.add(new RobotVacuumCleaner(CLEANERS, "Polaris", 1200, "Container", 2600));
        appliances.add(new RobotVacuumCleaner(CLEANERS, "XIAOMI", 1050, "Container", 2200));
        appliances.add(new VerticalVacuumCleaner(CLEANERS, "AENO", 490, "Container",
                false));
        appliances.add(new VerticalVacuumCleaner(CLEANERS, "LG", 570, "Bag",
                true));
        appliances.add(new AlarmClock(WATCH, "BRADEX", 27.56, WIRED_ALARM_CLOCK));
        appliances.add(new AlarmClock(WATCH, "BRADEX", 27.56, WIRELESS_ALARM_CLOCK));
        appliances.add(new LightAlarmClock(WATCH, "Kitfort", 34, WIRED_ALARM_CLOCK, 200));
        appliances.add(new LightAlarmClock(WATCH, "PHILIPS", 68, WIRED_ALARM_CLOCK, 200));
        appliances.add(new WeatherStation(WATCH, "BRADEX", 27.5, WIRELESS_ALARM_CLOCK, true));
        appliances.add(new WeatherStation(WATCH, "Rexant", 35, WIRELESS_ALARM_CLOCK, false));

        turnOnSomeAppliances(appliances);
    }

    public static void turnOnSomeAppliances(List<Appliance> appliances) {
        int random;
        for (Appliance a : appliances) {
            random = new Random().nextInt(101);
            a.turnOn(random % 2 == 0);
            System.out.println(a);
        }
    }
}
