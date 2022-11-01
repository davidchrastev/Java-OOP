package EncapsulationExercises.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Team> teams = new LinkedHashMap<>();

        while (!input.equals("END")) {
            try {
                String[] inputParts = input.split(";");
                String command = inputParts[0];
                String teamName = inputParts[1];

                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName,team);
                        break;
                    case "Add":
                        String playerName = inputParts[2];
                        int endurance = Integer.parseInt(inputParts[3]);
                        int sprint = Integer.parseInt(inputParts[4]);
                        int dribble = Integer.parseInt(inputParts[5]);
                        int passing = Integer.parseInt(inputParts[6]);
                        int shooting = Integer.parseInt(inputParts[7]);


                        if (teams.containsKey(teamName)) {
                            Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                            teams.get(teamName).addPlayer(player);
                        } else {
                            System.out.printf("Team %s does not exist.%n",teamName);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = inputParts[2];
                        teams.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (teams.containsKey(teamName)) {
                            System.out.printf("%s - %d%n",teamName,Math.round(teams.get(teamName).getRating()));
                        } else {
                            System.out.printf("Team %s does not exist.%n",teamName);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
