package exams.java.zooExam18_April_2022.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    private static final double TERRESTRIAL_KG = 5.50;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, TERRESTRIAL_KG, price);
    }

    @Override
    public void eat() {
        super.setKg(getKg() + 5.70);
    }
}
