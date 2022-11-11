package PolymorphismExercise.vehiclesExtension;

public class Truck extends Vehicle {

    public final static double ADDITIONAL_CONSUMPTION_AC = 1.6;
    public final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, ADDITIONAL_CONSUMPTION_AC);
    }


    @Override
    public void refuel(double litters) {
        super.refuel(litters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
