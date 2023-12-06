package day2;

import java.util.List;

public class Game {

    public int id;
    public List<GameSet> gameSets = new java.util.ArrayList<>();

    public Game(String line) {
        String[] parts = line.split(": ");
        this.id = Integer.parseInt(parts[0].split(" ")[1]);
        String[] sets = parts[1].split("; ");
        for (String set : sets) {
            this.gameSets.add(new GameSet(set));
        }
    }

    public int getId() {
        return id;
    }

    public boolean isValid(int maxRed, int maxGreen, int maxBlue) {
        for (GameSet gameSet : this.gameSets) {
            if (!gameSet.isValid(maxRed, maxGreen, maxBlue)) {
                return false;
            }
        }
        return true;
    }

    public int getPower() {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;
        for (GameSet gameSet : gameSets) {
            maxRed = Math.max(maxRed, gameSet.red);
            maxGreen = Math.max(maxGreen, gameSet.green);
            maxBlue = Math.max(maxBlue, gameSet.blue);
        }
        return maxRed * maxBlue * maxGreen;
    }
}
