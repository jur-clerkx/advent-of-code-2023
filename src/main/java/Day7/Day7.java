package Day7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import utils.FileLoader;

public class Day7 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Hand> regularHands = FileLoader.readFile("day7.txt").stream().map(s -> Hand.fromLine(s, false)).toList();
        System.out.println(calculateWinnings(regularHands));
        List<Hand> jokerHands = FileLoader.readFile("day7.txt").stream().map(s -> Hand.fromLine(s, true)).toList();
        System.out.println(calculateWinnings(jokerHands));
    }

    public static long calculateWinnings(List<Hand> hands) {
        hands = hands.stream().sorted().toList();
        long total = 0;
        for(Hand hand : hands) {
            total += hand.getBid() * (hands.indexOf(hand) + 1L);
        }
        return total;
    }
}
