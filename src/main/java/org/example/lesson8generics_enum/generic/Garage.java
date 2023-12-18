package org.example.lesson8generics_enum.generic;

public class Garage<T extends Vehicle> {
    private T vehicle;

    public void addVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public void printVehicleName() {
        System.out.println(vehicle.getName());
    }

    public T getVehicle() {
        return vehicle;
    }
}
