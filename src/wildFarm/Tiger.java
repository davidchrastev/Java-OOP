package wildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Tiger", animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            super.setFoodEaten(food.getQuantity());
        } else {
            super.setFoodEaten(0);
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
