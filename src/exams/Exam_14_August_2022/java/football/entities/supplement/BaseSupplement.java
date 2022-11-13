package exams.Exam_14_August_2022.java.football.entities.supplement;

public class BaseSupplement implements Supplement {
    private int energy;
    private double price;

    public BaseSupplement(int energy, double price) {
        this.energy = energy;
        this.price = price;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
