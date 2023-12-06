package day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.FileLoader;

public class Day2 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Game> games = FileLoader.readFile("day2.txt").stream().map(Game::new).toList();
        System.out.println(new Day2().getSumOfValidGames(games, 12, 13, 14));
        System.out.println(new Day2().getSumOfPowerOfGames(games));
    }

    public int getSumOfValidGames(List<Game> games, int maxRed, int maxGreen, int maxBlue) {
        return games.stream().filter(game -> game.isValid(maxRed, maxGreen, maxBlue)).mapToInt(Game::getId).sum();
    }

    public int getSumOfPowerOfGames(List<Game> games) {
        return games.stream().mapToInt(Game::getPower).sum();
    }
}