public class Main {
    public static void main(String[] args) {
       Truck carTransporter = new Truck("Kenworth","AS336667Y87", "USA", true, false, 2, true, 400, true, true);
       System.out.printf("%s developed in %s with VIN %s", carTransporter.getModel(),carTransporter.getManufacturer(),carTransporter.getVIN ());
    }
}