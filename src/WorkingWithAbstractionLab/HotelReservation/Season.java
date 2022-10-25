package WorkingWithAbstractionLab.HotelReservation;

public enum Season {

    Summer("Summer",4),
    Autumn("Autumn",1),
    Winter("Winter",3),
    Spring("Spring",2);

    private String name;
    private int multiplyCoefficent;

    Season(String name, int multiplyCoefficent) {
        this.name = name;
        this.multiplyCoefficent = multiplyCoefficent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplyCoefficent() {
        return multiplyCoefficent;
    }

    public void setMultiplyCoefficent(int multiplyCoefficent) {
        this.multiplyCoefficent = multiplyCoefficent;
    }
}
