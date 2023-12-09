package vehicles;

public class HomeFuel extends Truck {
    private boolean barrelOfFuel;

    private int barrelVolume;

    private boolean barrelNeck;

    private boolean drainer;

    private boolean grounding;

    public HomeFuel(String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, int countofSpleppingPlaces, boolean hasCargoRefrigerator, int carrying, boolean automaticCoupler, boolean tractorCrane, boolean barrelOfFuel, int barrelVolume, boolean barrelNeck, boolean drainer, boolean grounding) {
        super(model, VIN, manufacturer, hasAirBags, isAutomaticTransmission, countofSpleppingPlaces, hasCargoRefrigerator, carrying, automaticCoupler, tractorCrane);
        this.barrelOfFuel = barrelOfFuel;
        this.barrelVolume = barrelVolume;
        this.barrelNeck = barrelNeck;
        this.drainer = drainer;
        this.grounding = grounding;
    }

    public boolean isBarrelOfFuel() {
        return barrelOfFuel;
    }

    public void setBarrelOfFuel(boolean barrelOfFuel) {
        this.barrelOfFuel = barrelOfFuel;
    }

    public int getBarrelVolume() {
        return barrelVolume;
    }

    public void setBarrelVolume(int barrelVolume) {
        this.barrelVolume = barrelVolume;
    }

    public boolean isBarrelNeck() {
        return barrelNeck;
    }

    public void setBarrelNeck(boolean barrelNeck) {
        this.barrelNeck = barrelNeck;
    }

    public boolean isDrainer() {
        return drainer;
    }

    public void setDrainer(boolean drainer) {
        this.drainer = drainer;
    }

    public boolean isGrounding() {
        return grounding;
    }

    public void setGrounding(boolean grounding) {
        this.grounding = grounding;
    }

    @Override
    public String toString() {
        return "HomeFuel{" +
                "barrelOfFuel=" + barrelOfFuel +
                ", barrelVolume=" + barrelVolume +
                ", barrelNeck=" + barrelNeck +
                ", drainer=" + drainer +
                ", grounding=" + grounding +
                "} " + super.toString();
    }
}
