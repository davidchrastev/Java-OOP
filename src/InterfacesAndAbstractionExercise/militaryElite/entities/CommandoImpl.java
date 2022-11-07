package InterfacesAndAbstractionExercise.militaryElite.entities;

import InterfacesAndAbstractionExercise.militaryElite.enums.Corps;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.Commando;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f",super.getFirstName(),super.getLastName(),super.getId(),super.getSalary())).append(System.lineSeparator());
        stringBuilder.append("Corps: ").append(super.getCorps()).append(System.lineSeparator());
        stringBuilder.append("Missions:");

        if (!missions.isEmpty()) {
            stringBuilder.append(System.lineSeparator());
        }

        for (Mission mission : missions) {
            stringBuilder.append(mission).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();

    }
}
