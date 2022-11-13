package exams.Exam_14_August_2022.java.football.entities.player;

public class Women extends BasePlayer{
    private static final double WOMEN_KG = 60;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, WOMEN_KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(super.getStrength() + 115);
    }
}
