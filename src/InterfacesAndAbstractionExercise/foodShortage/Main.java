package InterfacesAndAbstractionExercise.foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople = Integer.parseInt(scanner.nextLine());
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        for (int i = 0; i < countPeople; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            if (data.length == 4) {
                String id = data[2];
                String birthDate = data[3];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                citizens.add(citizen);
            } else {
                String group = data[2];
                Rebel rebel = new Rebel(name,age,group);
                rebels.add(rebel);
            }
        }

        String name = scanner.nextLine();
        while (!"End".equals(name)) {

            citizenBuyFood(citizens,name);
            rebelBuyFood(rebels, name);
            name = scanner.nextLine();
        }
        int boughtFood = getBoughtFood(citizens, rebels);
        System.out.println(boughtFood);

    }

    private static int getBoughtFood(List<Citizen> citizens, List<Rebel> rebels) {
        int boughtFood = 0;
        for (Citizen citizen : citizens) {
            boughtFood += citizen.getFood();
        }
        for (Rebel rebel : rebels) {
            boughtFood += rebel.getFood();
        }
        return boughtFood;
    }

    private static void rebelBuyFood(List<Rebel> rebels, String name) {
        for (Rebel rebel : rebels) {
            if (rebel.getName().equals(name)) {
                rebel.buyFood();
            }
        }
    }

    private static void citizenBuyFood(List<Citizen> citizens, String name) {

        for (Citizen citizen : citizens) {
            if (citizen.getName().equals(name)) {
                citizen.buyFood();
            }
        }
    }
}
