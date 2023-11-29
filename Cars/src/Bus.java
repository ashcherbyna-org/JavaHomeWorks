public class Bus extends Vehicle{

    private boolean hasRamp;
    private boolean automaticDoors;
    private int numberOfSeats;
    private boolean cargoBelts;
    private boolean routeNumber;

    public Bus(String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, boolean hasRamp, boolean automaticDoors, int numberOfSeats, boolean cargoBelts, boolean routeNumber) {
        super(model, VIN, manufacturer, hasAirBags, isAutomaticTransmission);
        this.hasRamp = hasRamp;
        this.automaticDoors = automaticDoors;
        this.numberOfSeats = numberOfSeats;
        this.cargoBelts = cargoBelts;
        this.routeNumber = routeNumber;
    }

    public boolean isHasRamp() {
        return hasRamp;
    }

    public void setHasRamp(boolean hasRamp) {
        this.hasRamp = hasRamp;
    }

    public boolean isAutomaticDoors() {
        return automaticDoors;
    }

    public void setAutomaticDoors(boolean automaticDoors) {
        this.automaticDoors = automaticDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isCargoBelts() {
        return cargoBelts;
    }

    public void setCargoBelts(boolean cargoBelts) {
        this.cargoBelts = cargoBelts;
    }

    public boolean isRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(boolean routeNumber) {
        this.routeNumber = routeNumber;
    }
}
