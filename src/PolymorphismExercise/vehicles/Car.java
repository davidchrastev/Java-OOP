package PolymorphismExercise.vehicles;

public class Car extends Vehicle {

    private final static double ADDITIONAL_CONSUMPTION_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(getFuelConsumption() + ADDITIONAL_CONSUMPTION_AC);
    }

}
