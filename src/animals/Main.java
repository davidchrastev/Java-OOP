package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!"Beast!".equals(animalType)) {
            String[] dataAnimal = scanner.nextLine().split(" ");
            String name = dataAnimal[0];
            int age = Integer.parseInt(dataAnimal[1]);
            String gender = dataAnimal[2];

            try {
                switch (animalType) {
                    case "Cat":
                        Cat cat = new Cat(name,age,gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name,age,gender);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name,age,gender);
                        System.out.println(dog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name,age);

                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name,age);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = scanner.nextLine();
        }
    }
}
