package exams.Exam_22_August_2022.java.goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer{
    private static final double GEOLOGIST_DISCOVERER_ENERGY = 100;

    public Geologist(String name) {
        super(name, GEOLOGIST_DISCOVERER_ENERGY);
    }
}
