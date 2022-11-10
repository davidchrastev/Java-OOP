package vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;


    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();

        if (fuelNeeded >= getFuelQuantity()) {
            return String.format("%s needs refueling",this.getClass().getSimpleName());
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));
    }
    public void refuel(double litters) {
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
