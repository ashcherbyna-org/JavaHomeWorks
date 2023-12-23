package vehicles;

import vehicles.abstractions.AbstractVehicle;

public class Motorcycle extends AbstractVehicle {
    private boolean sideCar;
    private boolean hasTrunk;
    private boolean footrests;
    private boolean verticalFit;
    private boolean helmet;

    public Motorcycle(int ID, String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, boolean sideCar, boolean hasTrunk, boolean footrests, boolean verticalFit, boolean helmet) {
        super(ID, model, VIN, manufacturer, hasAirBags, isAutomaticTransmission);
        this.sideCar = sideCar;
        this.hasTrunk = hasTrunk;
        this.footrests = footrests;
        this.verticalFit = verticalFit;
        this.helmet = helmet;
    }


    public boolean isSideCar() {
        return sideCar;
    }

    public void setSideCar(boolean sideCar) {
        this.sideCar = sideCar;
    }

    public boolean isHasTrunk() {
        return hasTrunk;
    }

    public void setHasTrunk(boolean hasTrunk) {
        this.hasTrunk = hasTrunk;
    }

    public boolean isFootrests() {
        return footrests;
    }

    public void setFootrests(boolean footrests) {
        this.footrests = footrests;
    }

    public boolean isVerticalFit() {
        return verticalFit;
    }

    public void setVerticalFit(boolean verticalFit) {
        this.verticalFit = verticalFit;
    }

    public boolean isHelmet() {
        return helmet;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    @Override
    public int getWheelCount() {
        return 2;
    }

    @Override
    public String toString() {
        final var sb = new StringBuffer("Motorcycle{");
        sb.append("sideCar=").append(sideCar);
        sb.append(", hasTrunk=").append(hasTrunk);
        sb.append(", footrests=").append(footrests);
        sb.append(", verticalFit=").append(verticalFit);
        sb.append(", helmet=").append(helmet);
        sb.append('}');
        return sb.toString();
    }
}
