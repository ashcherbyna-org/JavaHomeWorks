package vehicles;

import vehicles.abstractions.AbstractVehicle;

import java.util.StringJoiner;

public class Truck extends AbstractVehicle {
    private int countofSpleppingPlaces;
    private boolean hasCargoRefrigerator;
    private int carrying;
    private boolean automaticCoupler;
    private boolean tractorCrane;

    public Truck(String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, int countofSpleppingPlaces, boolean hasCargoRefrigerator, int carrying, boolean automaticCoupler, boolean tractorCrane) {
        super(model, VIN, manufacturer, hasAirBags, isAutomaticTransmission);
        this.countofSpleppingPlaces = countofSpleppingPlaces;
        this.hasCargoRefrigerator = hasCargoRefrigerator;
        this.carrying = carrying;
        this.automaticCoupler = automaticCoupler;
        this.tractorCrane = tractorCrane;
    }

    public int getCountofSpleppingPlaces() {
        return countofSpleppingPlaces;
    }

    public void setCountofSpleppingPlaces(int countofSpleppingPlaces) {
        this.countofSpleppingPlaces = countofSpleppingPlaces;
    }

    public boolean isHasCargoRefrigerator() {
        return hasCargoRefrigerator;
    }

    public void setHasCargoRefrigerator(boolean hasCargoRefrigerator) {
        this.hasCargoRefrigerator = hasCargoRefrigerator;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public boolean isAutomaticCoupler() {
        return automaticCoupler;
    }

    public void setAutomaticCoupler(boolean automaticCoupler) {
        this.automaticCoupler = automaticCoupler;
    }

    public boolean isTractorCrane() {
        return tractorCrane;
    }

    public void setTractorCrane(boolean tractorCrane) {
        this.tractorCrane = tractorCrane;
    }

    @Override
    public int getWheelCount() {
        return 6;
    }

    @Override
    public String toString() {
        return new StringJoiner(". ", Truck.class.getSimpleName() + "[", "]")
                .add("countofSpleppingPlaces=" + countofSpleppingPlaces)
                .add("hasCargoRefrigerator=" + hasCargoRefrigerator)
                .add("carrying=" + carrying)
                .add("automaticCoupler=" + automaticCoupler)
                .add("tractorCrane=" + tractorCrane)
                .toString();
    }
}