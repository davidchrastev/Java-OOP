package PolymorphismExercise.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",this.getAnimalType(),this.getAnimalName(),df.format(this.getAnimalWeight()),this.getLivingRegion(),this.getFoodEaten());
    }

}
