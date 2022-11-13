package exams.Exam_22_August_2022.java.goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public class BaseDiscoverer implements Discoverer{

    private String name;
    private double energy;
    private Museum museum;
    private static final int DEFAULT_ENERGY_INSPECT = 15;

    public BaseDiscoverer(String name, double energy) {
        this.name = name;
        this.energy = energy;
        museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Discoverer name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot create Discoverer with negative energy.");
        }
        this.energy = energy;
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    @Override
    public void dig() {
        energy -= DEFAULT_ENERGY_INSPECT;

        if (energy < 0) {
            energy = 0;
        }

    }
}
