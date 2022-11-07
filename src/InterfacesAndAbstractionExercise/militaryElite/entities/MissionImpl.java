package InterfacesAndAbstractionExercise.militaryElite.entities;

import InterfacesAndAbstractionExercise.militaryElite.interfaces.Mission;

public class MissionImpl implements Mission {

    public enum Status {
        inProgress,
        finished;
    }
    private String codeName;
    private Status status;


    public MissionImpl(String codeName, Status status) {
        this.codeName = codeName;
        this.status = status;
    }
    @Override
    public void completeMission() {
        this.status = Status.finished;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",codeName,status);
    }
}
