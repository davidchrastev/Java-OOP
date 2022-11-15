package exams.Exam_18_April_2022.java.zoo.entities.foods;

public class Meat extends BaseFood {
    private static final int MEAT_CALORIES = 50;
    private static final double MEAT_PRICE = 5;

    public Meat() {
        super(MEAT_CALORIES, MEAT_PRICE);
    }
}
