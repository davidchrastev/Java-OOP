package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(data[1]),Double.parseDouble(data[2]));
        data = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(data[1]),Double.parseDouble(data[2]));

        int countOperations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOperations; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String command = commands[0];
            String type = commands[1];
            double distanceToDrive = Double.parseDouble(commands[2]);

            switch (type) {
                case "Car":
                    if (command.equals("Drive")) {
                        System.out.println(car.drive(distanceToDrive));
                    } else {
                        car.refuel(distanceToDrive);
                    }
                    break;
                case "Truck":
                    if (command.equals("Drive")) {
                        System.out.println(truck.drive(distanceToDrive));
                    } else {
                        truck.refuel(distanceToDrive);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);


    }
}
