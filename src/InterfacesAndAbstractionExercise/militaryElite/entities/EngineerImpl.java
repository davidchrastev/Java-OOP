package InterfacesAndAbstractionExercise.militaryElite.entities;

import InterfacesAndAbstractionExercise.militaryElite.enums.Corps;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.Engineer;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepair() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f",super.getFirstName(),super.getLastName(),super.getId(),super.getSalary()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("Corps: %s",super.getCorps())).append(System.lineSeparator());
        stringBuilder.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : repairs) {
            stringBuilder.append("  ").append(repair).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
