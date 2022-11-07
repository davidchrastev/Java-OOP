package InterfacesAndAbstractionExercise.militaryElite.entities;

import InterfacesAndAbstractionExercise.militaryElite.interfaces.LieutenantGeneral;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f",super.getFirstName(),super.getLastName(),super.getId(),super.getSalary())).append(System.lineSeparator());
        stringBuilder.append("Privates:").append(System.lineSeparator());
        for (Private priv : privates) {
            stringBuilder.append("  ").append(priv).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
