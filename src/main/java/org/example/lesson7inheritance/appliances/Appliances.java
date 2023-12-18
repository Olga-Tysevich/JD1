package org.example.lesson7inheritance.appliances;

public abstract class Appliances {
    private AppliancesCategory category;
    private String brand;
    private double price;
    private boolean isOn;

    public Appliances(AppliancesCategory category, String brand, double price) {
        this.category = category;
        this.brand = brand;
        this.price = price;
    }

    public AppliancesCategory getCategory() {
        return category;
    }

    public void setCategory(AppliancesCategory category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void turnOn(boolean isOn) {
        this.isOn = isOn;
    }
    @Override
    public String toString() {
        return "Brand='" + brand +
                ", price=" + price +
                ", isOn=" + isOn;
    }
}
