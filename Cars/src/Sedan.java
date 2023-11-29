public class Sedan extends Vehicle{
    private boolean hasPassengerSeats;
    private boolean hasBabySeat;
    private boolean hasConvertibleRoof;
    private boolean ABS;
    private boolean luke;

    public Sedan(String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, boolean hasPassengerSeats, boolean hasBabySeat, boolean hasConvertibleRoof, boolean ABS, boolean luke) {
        super(model, VIN, manufacturer, hasAirBags, isAutomaticTransmission);
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
}
