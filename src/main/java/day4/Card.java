package day4;

import java.util.*;

public record Card(List<Integer> numbers, List<Integer> winningNumbers) {

    public static Card fromLine(String line) {//Line example: Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        String[] parts = line.split(":")[1].split("\\|");
        String[] winningNumbers = parts[0].trim().split(" ");
        String[] numbers = parts[1].trim().split(" ");
        return new Card(Arrays.stream(numbers).filter(input -> !input.isBlank()).mapToInt(Integer::parseInt).boxed().toList(),
                Arrays.stream(winningNumbers).filter(input -> !input.isBlank()).mapToInt(Integer::parseInt).boxed().toList());
    }

    public int getScore() {
        int count =  getWinCount();
        if (count == 0) {
            return 0;
        } else {
            return (int) Math.pow(2, count - 1);
        }
    }

    public int getWinCount() {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public List<Card> processToCards(List<Card> cards) {
        int index = cards.indexOf(this);
        int winIndex = index + this.getWinCount();
        List<Card> result = new ArrayList<>();
        result.add(this);
        while(index < winIndex) {
            index++;
            result.addAll(cards.get(index).processToCards(cards));
        }
        return result;
    }
}
