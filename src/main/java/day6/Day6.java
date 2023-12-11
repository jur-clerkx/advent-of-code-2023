package day6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import utils.FileLoader;

public class Day6 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Race> races = parseRaces(FileLoader.readFile("day6.txt"));

        System.out.println(races.stream().map(Race::getNumberOfWinningCombinations).reduce(1, (a, b) -> a * b));
        System.out.println(new Race(61677571L, 430103613071150L).getNumberOfWinningCombinations());
    }

    public static List<Race> parseRaces(List<String> lines) {
        int[] times = Arrays.stream(lines.getFirst().replace("Time:", "").trim().split("[ \\t]+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] distances = Arrays.stream(lines.getLast().replace("Distance:", "").trim().split("[ \\t]+"))
                .mapToInt(Integer::parseInt).toArray();
        List<Race> result = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            result.add(new Race(times[i], distances[i]));
        }
        return result;
    }
}
