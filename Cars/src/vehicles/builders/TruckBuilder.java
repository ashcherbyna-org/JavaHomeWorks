package vehicles.builders;

import vehicles.Truck;

public class TruckBuilder {
    private String model;
    private String vin;
    private String manufacturer;
    private boolean hasAirBags;
    private boolean isAutomaticTransmission;
    private int countofSpleppingPlaces;
    private boolean hasCargoRefrigerator;
    private int carrying;
    private boolean automaticCoupler;
    private boolean tractorCrane;

    public TruckBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public TruckBuilder setVIN(String vin) {
        this.vin = vin;
        return this;
    }

    public TruckBuilder setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public TruckBuilder setHasAirBags(boolean hasAirBags) {
        this.hasAirBags = hasAirBags;
        return this;
    }

    public TruckBuilder setIsAutomaticTransmission(boolean isAutomaticTransmission) {
        this.isAutomaticTransmission = isAutomaticTransmission;
        return this;
    }

    public TruckBuilder setCountofSpleppingPlaces(int countofSpleppingPlaces) {
        this.countofSpleppingPlaces = countofSpleppingPlaces;
        return this;
    }

    public TruckBuilder setHasCargoRefrigerator(boolean hasCargoRefrigerator) {
        this.hasCargoRefrigerator = hasCargoRefrigerator;
        return this;
    }

    public TruckBuilder setCarrying(int carrying) {
        this.carrying = carrying;
        return this;
    }

    public TruckBuilder setAutomaticCoupler(boolean automaticCoupler) {
        this.automaticCoupler = automaticCoupler;
        return this;
    }

    public TruckBuilder setTractorCrane(boolean tractorCrane) {
        this.tractorCrane = tractorCrane;
        return this;
    }

    public Truck createTruck() {
        return new Truck(model, vin, manufacturer, hasAirBags, isAutomaticTransmission, countofSpleppingPlaces, hasCargoRefrigerator, carrying, automaticCoupler, tractorCrane);
    }
}