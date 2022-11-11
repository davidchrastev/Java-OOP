package PolymorphismExercise.vehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double additionalACConsumption;


    public Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity,double additionalACConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.additionalACConsumption = additionalACConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String driveAC(double distance) {
        setFuelConsumption(getFuelConsumption() + additionalACConsumption);
        String result = this.drive(distance);
        setFuelConsumption(getFuelConsumption() - additionalACConsumption);
        return result;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();

        if (fuelNeeded > getFuelQuantity()) {
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));
    }
    public void refuel(double litters) {
        if (litters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity + litters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(getFuelQuantity() + litters);
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),getFuelQuantity());
    }
}
