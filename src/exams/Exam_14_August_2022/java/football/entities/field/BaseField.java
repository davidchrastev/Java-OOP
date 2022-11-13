package exams.Exam_14_August_2022.java.football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BaseField implements Field {

    private String name;
    private int capacity;
    private List<Supplement> supplements;
    private List<Player> players;


    public BaseField(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        int sum = 0;
        for (Supplement supplement : supplements) {
            sum += supplement.getEnergy();
        }
        return sum;
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() < capacity) {
            players.add(player);
        } else {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        if (players.contains(player)) {
            players.remove(player);
        }
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder()
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Player: ");

        if (this.players.isEmpty()) {
            output.append("none");
        } else {
            output.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }

        output.append(System.lineSeparator())
                .append("Supplement: ")
                .append(this.supplements.size())
                .append(System.lineSeparator())
                .append("Energy: ")
                .append(this.sumEnergy());

        return output.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
