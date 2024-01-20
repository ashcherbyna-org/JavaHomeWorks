package vehicles;

import vehicles.interfaces.PublicTransport;

public class  SedanTaxi extends Sedan implements PublicTransport {

    public SedanTaxi(int ID, String model, String VIN, String manufacturer, boolean hasAirBags, boolean isAutomaticTransmission, boolean hasPassengerSeats, boolean hasBabySeat, boolean hasConvertibleRoof, boolean ABS, boolean luke) {
        super(ID, model, VIN, manufacturer, hasAirBags, isAutomaticTransmission, hasPassengerSeats, hasBabySeat, hasConvertibleRoof, ABS, luke);
    }
    @Override
    public void pickUpPassengers() {
        System.out.println("No more than 4 passengers!");
    }
    @Override
    public void dropOffPassengers() {
        System.out.println("Stops at the request of the passenger.");
    }
    @Override
    public boolean announceNextStop() {
        return false;
    }
    @Override
    public double calculateFare() {
        return 100;
    }

    @Override
    public String toString() {
        return "SedanTaxi{} " + super.toString();
    }
}
