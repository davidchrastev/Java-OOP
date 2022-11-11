package PolymorphismExercise.vehiclesExtension;

public class Car extends Vehicle {

    private final static double ADDITIONAL_CONSUMPTION_AC = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, ADDITIONAL_CONSUMPTION_AC);
    }
}
