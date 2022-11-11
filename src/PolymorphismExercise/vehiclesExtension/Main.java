package PolymorphismExercise.vehiclesExtension;



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);
        Vehicle bus = (getVehicle(scanner));

        int countOperations = Integer.parseInt(scanner.nextLine());

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car",car);
        vehicleMap.put("Truck",truck);
        vehicleMap.put("Bus",bus);




        for (int i = 0; i < countOperations; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String command = commands[0];
            String type = commands[1];
            double argument = Double.parseDouble(commands[2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehicleMap.get(type).driveAC(argument));
                    break;
                case "Refuel":
                    try {
                        vehicleMap.get(type).refuel(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(vehicleMap.get(type).drive(argument));
                    break;

            }
        }

        vehicleMap.forEach((key, value) -> System.out.println(value));

    }
    public static Vehicle getVehicle(Scanner scanner) {
        String[] data = scanner.nextLine().split(" ");
        String vehicleType = data[0];
        double fuelAmount = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption, Double.parseDouble(data[3]));
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, Double.parseDouble(data[3]));
            case "Bus":
                return new Bus(fuelAmount, fuelConsumption, Double.parseDouble(data[3]));
        }
        return null;
    }
}

