package org.example.lesson7inheritance.appliances.cleaners;

import org.example.lesson7inheritance.appliances.AppliancesCategory;

public class VerticalVacuumCleaner extends VacuumCleaner{
    private boolean isConnectsToPowerTools;

    public VerticalVacuumCleaner(AppliancesCategory category, String brand, double price, String dustContainerType, boolean isConnectsToPowerTools) {
        super(category, brand, price, dustContainerType);
        this.isConnectsToPowerTools = isConnectsToPowerTools;
    }

    public boolean isConnectsToPowerTools() {
        return isConnectsToPowerTools;
    }

    public void setConnectsToPowerTools(boolean connectsToPowerTools) {
        isConnectsToPowerTools = connectsToPowerTools;
    }

    @Override
    public String toString() {
        return super.toString() + ", isConnectsToPowerTools=" + isConnectsToPowerTools;
    }
}
