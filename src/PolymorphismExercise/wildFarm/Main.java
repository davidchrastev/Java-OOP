package PolymorphismExercise.wildFarm;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] foodData = scanner.nextLine().split(" ");
            Animal animal = getAnimal(input);

            animal.makeSound();

            Food food = getFood(foodData);
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }



    private static Animal getAnimal(String input) {
        String[] animalData = input.split(" ");

        String animalType = animalData[0];

        String animalName = animalData[1];

        double animalWeight = Double.parseDouble(animalData[2]);

        String livingRegion = animalData[3];

        Animal animal = null;

        switch (animalType) {
            case "Cat":
                String catBreed = animalData[4];
                animal = new Cat(animalName,animalWeight,livingRegion,catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName,animalWeight,livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName,animalWeight,livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(animalName,animalWeight,livingRegion);
                break;
        }

        return animal;

    }

    private static Food getFood(String[] foodData) {
        String typeFood = foodData[0];
        int quantity = Integer.parseInt(foodData[1]);
        Food food = null;
        switch (typeFood) {
            case "Meat":
                food = new Meat(quantity);
                break;
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
        }
        return food;
    }
}
