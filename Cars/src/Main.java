import vehicles.builders.TruckBuilder;
import vehicles.Truck;

public class Main {
    public static void main(String[] args) {
       Truck carTransporter = new TruckBuilder()
               .setModel("Kenworth")
               .setVIN("AS336667Y87")
               .setManufacturer("USA")
               .setHasAirBags(true)
               .setIsAutomaticTransmission(false)
               .setCountofSpleppingPlaces(2)
               .setHasCargoRefrigerator(true)
               .setCarrying(400)
               .setAutomaticCoupler(true)
               .setTractorCrane(true)
               .createTruck();
       System.out.printf("%s developed in %s with VIN %s", carTransporter.getModel(),carTransporter.getManufacturer(),carTransporter.getVIN ());
        System.out.println();
       System.out.println(carTransporter);
    }
}