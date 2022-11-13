package exams.Exam_22_August_2022.java.goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public interface Discoverer {
    String getName();

    double getEnergy();

    boolean canDig();

    Museum getMuseum();

    void dig();
}
