package InterfacesAndAbstractionExercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] data = input.split(" ");
            String toCreate = data[0];

            switch (toCreate) {
                case "Citizen":
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String birthDate = data[4];
                    Citizen citizen = new Citizen(name,age,id,birthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String petName = data[1];
                    String petBirthDate = data[2];
                    Pet pet = new Pet(petName,petBirthDate);
                    birthables.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }
        String dateToSearch = scanner.nextLine();
        boolean noMatch = false;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(dateToSearch)) {
                System.out.println(birthable.getBirthDate());
                noMatch = true;
            } 
        }
        if (!noMatch) {
            System.out.println("<no output>");
        }
    }
}
