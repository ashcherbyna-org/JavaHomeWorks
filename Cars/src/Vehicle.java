public class Vehicle {
    private String model;
    private String VIN;
    private String manufacturer;
    private boolean hasAirBags;
    private boolean isAutomaticTransmission;

    public Vehicle(String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission) {
        this.model = model;
        this.VIN = VIN;
        this.manufacturer = manufacturer;
        this.hasAirBags = hasAirBags;
        this.isAutomaticTransmission = isAutomaticTransmission;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isHasAirBags() {
        return hasAirBags;
    }

    public void setHasAirBags(boolean hasAirBags) {
        this.hasAirBags = hasAirBags;
    }

    public boolean isAutomaticTransmission() {
        return isAutomaticTransmission;
    }

    public void setAutomaticTransmission(boolean automaticTransmission) {
        isAutomaticTransmission = automaticTransmission;
    }
}
