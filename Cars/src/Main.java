import vehicles.Sedan;
import vehicles.builders.TruckBuilder;
import vehicles.Truck;
import vehicles.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createTruck();
        var dataFromScan = readFileUsingScanner(FILE_NAME);
        for (int a = 1; a < dataFromScan.length; a++) {
            var pieces = dataFromScan[a].split(";");
            System.out.println(pieces[0]);
            Sedan sedan = null;
            switch (pieces[0]) {
                case "ECONOMY_CAR":
                    sedan = new EconomyCar(pieces[1],
                            pieces[2], pieces[3],
                            Boolean.parseBoolean(pieces[4]),
                            Boolean.parseBoolean(pieces[5]),
                            Boolean.parseBoolean(pieces[6]),
                            Boolean.parseBoolean(pieces[7]),
                            Boolean.parseBoolean(pieces[8]),
                            Boolean.parseBoolean(pieces[9]),
                            Boolean.parseBoolean(pieces[10]));
                    break;
                case "FAMILY_CAR":
                    sedan = new FamilyCar(pieces[1],
                        pieces[2], pieces[3],
                        Boolean.parseBoolean(pieces[4]),
                        Boolean.parseBoolean(pieces[5]),
                        Boolean.parseBoolean(pieces[6]),
                        Boolean.parseBoolean(pieces[7]),
                        Boolean.parseBoolean(pieces[8]),
                        Boolean.parseBoolean(pieces[9]),
                        Boolean.parseBoolean(pieces[10]));
                    break;
                case "LUXURY_CAR":
                    sedan = new LuxuryCar(pieces[1],
                            pieces[2],pieces[3],
                            Boolean.parseBoolean(pieces[4]),
                            Boolean.parseBoolean(pieces[5]),
                            Boolean.parseBoolean(pieces[6]),
                            Boolean.parseBoolean(pieces[7]),
                            Boolean.parseBoolean(pieces[8]),
                            Boolean.parseBoolean(pieces[9]),
                            Boolean.parseBoolean(pieces[10]));
                    break;
                case "OFFROAD":
                    sedan = new OffRoad(pieces[1],
                            pieces[2],pieces[3],
                            Boolean.parseBoolean(pieces[4]),
                            Boolean.parseBoolean(pieces[5]),
                            Boolean.parseBoolean(pieces[6]),
                            Boolean.parseBoolean(pieces[7]),
                            Boolean.parseBoolean(pieces[8]),
                            Boolean.parseBoolean(pieces[9]),
                            Boolean.parseBoolean(pieces[10]));
                    break;
                case "SPORTS_CAR":
                    sedan = new SportCar(pieces[1],
                            pieces[2],pieces[3],
                            Boolean.parseBoolean(pieces[4]),
                            Boolean.parseBoolean(pieces[5]),
                            Boolean.parseBoolean(pieces[6]),
                            Boolean.parseBoolean(pieces[7]),
                            Boolean.parseBoolean(pieces[8]),
                            Boolean.parseBoolean(pieces[9]),
                            Boolean.parseBoolean(pieces[10]));
                    break;

            }
            System.out.println(sedan.toString());
        }
    }

    private static void createTruck() {
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
        System.out.printf("%s developed in %s with VIN %s", carTransporter.getModel(), carTransporter.getManufacturer(), carTransporter.getVIN());
        System.out.println();
        System.out.println(carTransporter);
    }

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



