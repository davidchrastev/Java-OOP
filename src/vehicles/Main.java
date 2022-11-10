package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);

        int countOperations = Integer.parseInt(scanner.nextLine());

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car",car);
        vehicleMap.put("Truck",truck);

        for (int i = 0; i < countOperations; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String command = commands[0];
            String type = commands[1];
            double argument = Double.parseDouble(commands[2]);

            switch (command) {
                case "Drive" -> System.out.println(vehicleMap.get(type).drive(argument));
                case "Refuel" -> vehicleMap.get(type).refuel(argument);
            }
        }

        vehicleMap.entrySet().forEach(System.out::println);
        
    }
    public static Vehicle getVehicle(Scanner scanner) {
        String[] data = scanner.nextLine().split(" ");
        String vehicleType = data[0];
        double fuelAmount = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);

        return switch (vehicleType) {
            case "Car" -> new Car(fuelAmount, fuelConsumption);
            case "Truck" -> new Truck(fuelAmount, fuelConsumption);
            default -> null;
        };
    }
}
