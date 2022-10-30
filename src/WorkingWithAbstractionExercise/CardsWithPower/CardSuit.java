package WorkingWithAbstractionExercise.CardsWithPower;

public enum CardSuit {
    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3),
    SPADES(4);

    private int power;

    CardSuit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
