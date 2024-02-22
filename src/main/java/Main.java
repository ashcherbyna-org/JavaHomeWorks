import vehicles.Sedan;
import vehicles.abstractions.AbstractVehicle;
import vehicles.models.EconomyCar;
import vehicles.models.SportCar;
import vehicles.models.OffRoad;
import vehicles.models.LuxuryCar;
import vehicles.models.FamilyCar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    private static Logger logger;



    public static void main(String[] args) {

        var loggerconfig = System.getenv("FILE_NAME");
        System.setProperty("java.util.logging.config.file", loggerconfig);
        logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.CONFIG, "Read data from " + FILE_NAME);

        //createTruck();
        var dataFromScan = readFileUsingScanner(FILE_NAME);
        var sedanList = createSedansFromFile(dataFromScan);
        logger.log(Level.CONFIG, "Count of created cars " + sedanList.size());
    }

    private static void streams(ArrayList<Sedan> sedanList) {
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
    private static ArrayList<Sedan> createSedansFromFile(String[] dataFromScan) {
        var sedans = new ArrayList<Sedan>();
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
                logger.log(Level.SEVERE, "Economy cars");
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
                logger.log(Level.WARNING, "Family cars");
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
                logger.log(Level.INFO, "Luxury cars");
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
                logger.log(Level.FINE, "Offroad cars");
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
                logger.log(Level.FINER, "Sport cars");
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

    private static final String FILE_NAME = "src/main/resources/cars.csv";

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


