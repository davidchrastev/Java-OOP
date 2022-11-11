package wildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Zebra", animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            super.setFoodEaten(food.getQuantity());
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
