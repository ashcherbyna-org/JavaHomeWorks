package vehicles.interfaces;

public interface PublicTransport {
    void pickUpPassengers();
    void dropOffPassengers();
    boolean announceNextStop();
    double calculateFare();
}

