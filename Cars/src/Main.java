import vehicles.Sedan;
import vehicles.abstractions.AbstractVehicle;
import vehicles.models.EconomyCar;
import vehicles.models.SportCar;
import vehicles.models.OffRoad;
import vehicles.models.LuxuryCar;
import vehicles.models.FamilyCar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //createTruck();
        var sedanList = createSedansFromFile();
        System.out.println("SortSkip and SortOut");
        sedanList.stream()
                .sorted(Comparator.comparingInt(AbstractVehicle::getID))
                .skip(12)
                .limit(25)
                .forEach(sedan -> System.out.println(sedan));
        System.out.println("Filter Out");
        sedanList.stream()
                .filter(sedan -> sedan.getID() % 2 == 0)
                .limit(12)
                .forEach(sedan -> System.out.println(sedan));
        System.out.println("Map");

        var mapStream = sedanList.stream()
                .collect(Collectors.toMap(AbstractVehicle::getID, AbstractVehicle::getModel));
        System.out.println(mapStream);
    }

    //HW 7 read data from File (Csv)
    private static ArrayList<Sedan> createSedansFromFile() {
        var sedans = new ArrayList<Sedan>();
        var dataFromScan = readFileUsingScanner(FILE_NAME);
        for (int a = 1; a < dataFromScan.length; a++) {
            var pieces = dataFromScan[a].split(";");
            Sedan sedan = getSedanFromPeaces(pieces);
            sedans.add(sedan);
        }
        return sedans;
    }

    private static Sedan getSedanFromPeaces(String[] pieces) {
        switch (pieces[1]) {
            case "ECONOMY_CAR":
                return new EconomyCar(Integer.parseInt(pieces[0]),
                        pieces[2], pieces[3], pieces[4],
                        Boolean.parseBoolean(pieces[5]),
                        Boolean.parseBoolean(pieces[6]),
                        Boolean.parseBoolean(pieces[7]),
                        Boolean.parseBoolean(pieces[8]),
                        Boolean.parseBoolean(pieces[9]),
                        Boolean.parseBoolean(pieces[10]),
                        Boolean.parseBoolean(pieces[10]));
            case "FAMILY_CAR":
                return new FamilyCar(Integer.parseInt(pieces[0]),
                        pieces[2], pieces[3], pieces[4],
                        Boolean.parseBoolean(pieces[5]),
                        Boolean.parseBoolean(pieces[6]),
                        Boolean.parseBoolean(pieces[7]),
                        Boolean.parseBoolean(pieces[8]),
                        Boolean.parseBoolean(pieces[9]),
                        Boolean.parseBoolean(pieces[10]),
                        Boolean.parseBoolean(pieces[10]));
            case "LUXURY_CAR":
                return new LuxuryCar(Integer.parseInt(pieces[0]),
                        pieces[2], pieces[3], pieces[4],
                        Boolean.parseBoolean(pieces[5]),
                        Boolean.parseBoolean(pieces[6]),
                        Boolean.parseBoolean(pieces[7]),
                        Boolean.parseBoolean(pieces[8]),
                        Boolean.parseBoolean(pieces[9]),
                        Boolean.parseBoolean(pieces[10]),
                        Boolean.parseBoolean(pieces[10]));
            case "OFFROAD":
                return new OffRoad(Integer.parseInt(pieces[0]),
                        pieces[2], pieces[3], pieces[4],
                        Boolean.parseBoolean(pieces[5]),
                        Boolean.parseBoolean(pieces[6]),
                        Boolean.parseBoolean(pieces[7]),
                        Boolean.parseBoolean(pieces[8]),
                        Boolean.parseBoolean(pieces[9]),
                        Boolean.parseBoolean(pieces[10]),
                        Boolean.parseBoolean(pieces[10]));

            case "SPORTS_CAR":
                return new SportCar(Integer.parseInt(pieces[0]),
                        pieces[2], pieces[3], pieces[4],
                        Boolean.parseBoolean(pieces[5]),
                        Boolean.parseBoolean(pieces[6]),
                        Boolean.parseBoolean(pieces[7]),
                        Boolean.parseBoolean(pieces[8]),
                        Boolean.parseBoolean(pieces[9]),
                        Boolean.parseBoolean(pieces[10]),
                        Boolean.parseBoolean(pieces[10]));

            default:
                return null;
        }
    }

    //HW 5 create builder
//    private static void createTruck() {
//        Truck carTransporter = new TruckBuilder()
//                .setModel("Kenworth")
//                .setVIN("AS336667Y87")
//                .setManufacturer("USA")
//                .setHasAirBags(true)
//                .setIsAutomaticTransmission(false)
//                .setCountofSpleppingPlaces(2)
//                .setHasCargoRefrigerator(true)
//                .setCarrying(400)
//                .setAutomaticCoupler(true)
//                .setTractorCrane(true)
//                .createTruck();
//        System.out.printf("%s developed in %s with VIN %s", carTransporter.getModel(), carTransporter.getManufacturer(), carTransporter.getVIN());
//        System.out.println();
//        System.out.println(carTransporter);
//    }

    private static final String FILE_NAME = "resoursces/cars.csv";

    static String[] readFileUsingScanner(String filename) {
        ArrayList<String> data = new ArrayList<String>();
        var file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        boolean finish = false;
        do {
            try {
                data.add(scanner.nextLine());
            } catch (NoSuchElementException e) {
                finish = true;
            }

        } while (!finish);


        scanner.close();
        return Arrays.copyOf(data.toArray(), data.size(), String[].class);
    }

}



