package wildFarm;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] foodData = scanner.nextLine().split(" ");
            getAnimal(input,animals,foodData);

            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }



    private static void getAnimal(String input,List<Animal> animals,String[] foodData) {
        String[] animalData = input.split(" ");
//        "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}".

//        "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}"

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

        animals.add(animal);
        animal.makeSound();
        animal.eat(food);




    }
}
