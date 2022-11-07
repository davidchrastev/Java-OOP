package InterfacesAndAbstractionExercise.militaryElite.entities;

import InterfacesAndAbstractionExercise.militaryElite.enums.Corps;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    public Corps getCorps() {
        return corps;
    }
}
