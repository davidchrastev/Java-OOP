package InterfacesAndAbstractionLab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split(" ");

            Identifiable identifiable;
            if (data.length == 3) {
                identifiable = new Citizen(data[0],Integer.parseInt(data[1]),data[2]);
            } else {
                identifiable = new Robot(data[0],data[1]);
            }
            identifiables.add(identifiable);

            input = scanner.nextLine();
        }
        String fakeIdPostFix = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdPostFix))
                .forEach(System.out::println);
    }
}
