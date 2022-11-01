package EncapsulationExercises.PizzaCalories;

import java.util.Arrays;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }
    private void setFlourType(String flourType) {
        boolean flourExist = Arrays.stream(FlourTypes.values()).anyMatch(f -> f.name().equals(flourType));

        if (!flourExist) {
            throw new IllegalArgumentException("Invalid type of dough.");
        } else {
            this.flourType = flourType;
        }
    }


    private void setBakingTechnique(String bakingTechnique) {
        boolean bakingTechniqueExist = Arrays.stream(BakingTechniques.values()).anyMatch(b -> b.name().equals(bakingTechnique));

        if (!bakingTechniqueExist) {
            throw new IllegalArgumentException("Invalid type of dough.");
        } else {
            this.bakingTechnique = bakingTechnique;
        }
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
        return BakingTechniques.valueOf(bakingTechnique).getModifier();
    }

    private double getFlourModifier() {
        return FlourTypes.valueOf(flourType).getModifier();
    }
}
