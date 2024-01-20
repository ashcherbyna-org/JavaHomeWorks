package vehicles;

import vehicles.abstractions.AbstractVehicle;
import vehicles.enums.SedanClass;

public class Sedan extends AbstractVehicle {
    protected SedanClass sedanClass = null;
    private boolean hasPassengerSeats;
    private boolean hasBabySeat;
    private boolean hasConvertibleRoof;
    private boolean ABS;
    private boolean luke;

    public Sedan(int ID, String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, boolean hasPassengerSeats, boolean hasBabySeat, boolean hasConvertibleRoof, boolean ABS, boolean luke) {
        super(ID, model, VIN, manufacturer, hasAirBags, isAutomaticTransmission);
        this.hasPassengerSeats = hasPassengerSeats;
        this.hasBabySeat = hasBabySeat;
        this.hasConvertibleRoof = hasConvertibleRoof;
        this.ABS = ABS;
        this.luke = luke;
    }


    public boolean isHasPassengerSeats() {
        return hasPassengerSeats;
    }

    public void setHasPassengerSeats(boolean hasPassengerSeats) {
        this.hasPassengerSeats = hasPassengerSeats;
    }

    public boolean isHasBabySeat() {
        return hasBabySeat;
    }

    public void setHasBabySeat(boolean hasBabySeat) {
        this.hasBabySeat = hasBabySeat;
    }

    public boolean isHasConvertibleRoof() {
        return hasConvertibleRoof;
    }

    public void setHasConvertibleRoof(boolean hasConvertibleRoof) {
        this.hasConvertibleRoof = hasConvertibleRoof;
    }

    public boolean isABS() {
        return ABS;
    }

    public void setABS(boolean ABS) {
        this.ABS = ABS;
    }

    public boolean isLuke() {
        return luke;
    }

    public void setLuke(boolean luke) {
        this.luke = luke;
    }

    @Override
    public int getWheelCount() {
        return 4;
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder("Sedan{");
        sb.append("Id=").append(getID());
        sb.append(", hasPassengerSeats=").append(hasPassengerSeats);
        sb.append(", hasBabySeat=").append(hasBabySeat);
        sb.append(", hasConvertibleRoof=").append(hasConvertibleRoof);
        sb.append(", ABS=").append(ABS);
        sb.append(", luke=").append(luke);
        sb.append('}');
        return sb.toString();
    }
}
