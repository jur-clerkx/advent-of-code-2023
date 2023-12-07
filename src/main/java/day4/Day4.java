package day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import utils.FileLoader;

public class Day4 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Card> cards = FileLoader.readFile("day4.txt").stream().map(Card::fromLine).toList();
        System.out.println("Part 1: " + getSumOfCardValues(cards));
        System.out.println("Part 2: " + getAmountOfCardsWon(cards));

    }

    public static int getSumOfCardValues(List<Card> cards) {
        return cards.stream().mapToInt(Card::getScore).sum();
    }

    public static int getAmountOfCardsWon(List<Card> cards) {
        return cards.stream().map(card -> card.processToCards(cards)).flatMap(List::stream).toList().size();
    }
}
