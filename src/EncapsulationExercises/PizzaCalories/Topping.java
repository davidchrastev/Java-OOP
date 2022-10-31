package EncapsulationExercises.PizzaCalories;

import java.util.Arrays;

public class Topping {
    private ToppingTypes toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        boolean toppingExist = Arrays.stream(ToppingTypes.values()).anyMatch(t -> t.name().equals(toppingType));
        if (!toppingExist) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        } else {
            this.toppingType = ToppingTypes.valueOf(toppingType);
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * getToppingModifier();
    }

    private double getToppingModifier() {
        return toppingType.getModifier();
    }
}
