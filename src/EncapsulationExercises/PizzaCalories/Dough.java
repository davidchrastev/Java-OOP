package EncapsulationExercises.PizzaCalories;

import java.util.Arrays;

public class Dough {

    private FlourTypes flourType;
    private BakingTechniques bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }


    private void setFlourType(String flourType) {
        boolean toppingExist = Arrays.stream(FlourTypes.values()).anyMatch(t -> t.name().equals(flourType));

        if (!toppingExist) {
            throw new IllegalArgumentException("Invalid type of dough.");
        } else {
            this.flourType = FlourTypes.valueOf(flourType);
        }
    }


    private void setBakingTechnique(String bakingTechnique) {
        boolean bakingTechniqueExist = Arrays.stream(BakingTechniques.values()).anyMatch(b -> b.name().equals(bakingTechnique));

        if (!bakingTechniqueExist) {
            throw new IllegalArgumentException("Invalid type of dough.");
        } else {
            this.bakingTechnique = BakingTechniques.valueOf(bakingTechnique);
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * getBakingTechniqueModifier() * getFlourModifier();
    }

    private double getBakingTechniqueModifier() {
        return bakingTechnique.getModifier();
    }

    private double getFlourModifier() {
        return flourType.getModifier();
    }
}
