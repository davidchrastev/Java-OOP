package InterfacesAndAbstractionExercise.foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople = Integer.parseInt(scanner.nextLine());
        List<Person> buyers = new ArrayList<>();

        for (int i = 0; i < countPeople; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            if (data.length == 4) {
                String id = data[2];
                String birthDate = data[3];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                buyers.add(citizen);
            } else {
                String group = data[2];
                Rebel rebel = new Rebel(name,age,group);
                buyers.add(rebel);
            }
        }

        String name = scanner.nextLine();
        while (!"End".equals(name)) {
            buyFood(buyers,name);
            name = scanner.nextLine();
        }
        int boughtFood = getBoughtFood(buyers);
        System.out.println(boughtFood);


    }

    private static int getBoughtFood(List<Person> buyers) {
        int boughtFood = 0;
        for (Person person : buyers) {
            boughtFood += person.getFood();
        }
        return boughtFood;
    }

    private static void buyFood(List<Person> buyers, String name) {
        for (Person person : buyers) {
            if (person.getName().equals(name)) {
                person.buyFood();
            }
        }
    }

}
