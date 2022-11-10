package vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public final static double ADDITIONAL_CONSUMPTION_AC = 1.6;
    public final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION_AC);
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > getFuelQuantity()) {
            return "Truck needs refueling";
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("Truck travelled %s km",df.format(distance));
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
