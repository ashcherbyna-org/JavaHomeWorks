package vehicles.models;

import vehicles.Sedan;
import vehicles.enums.SedanClass;

import java.util.StringJoiner;

public class SportCar extends Sedan {
    public SportCar(String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, boolean hasPassengerSeats, boolean hasBabySeat, boolean hasConvertibleRoof, boolean ABS, boolean luke) {
        super(model, VIN, manufacturer, hasAirBags, isAutomaticTransmission, hasPassengerSeats, hasBabySeat, hasConvertibleRoof, ABS, luke);
        sedanClass = SedanClass.SPORTS_CAR;
    }

    @Override
    public String toString() {
        return "EconomyCar{" +
                "sedanClass=" + sedanClass +
                "} " + super.toString();
    }
}
