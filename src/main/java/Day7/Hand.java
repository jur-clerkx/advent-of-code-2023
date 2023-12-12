package Day7;

import java.util.*;

public class Hand implements Comparable<Hand> {

    public static final List<Character> cardValues = List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
    public static final List<Character> jokerCardValues = List.of('J', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A');

    private final String hand;
    private final int bid;
    private final int type;

    private final boolean jokerRule;

    public Hand(String hand, int bid, boolean jokerRule) {
        this.hand = hand;
        this.bid = bid;
        this.jokerRule = jokerRule;
        this.type = calculateType(hand, this.jokerRule);
    }

    public String getHand() {
        return hand;
    }

    public int getBid() {
        return bid;
    }

    public int getType() {
        return type;
    }

    public static int calculateType(String hand, boolean jokerRule) {
        Map<Character, Long> counted = hand.chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.counting()));
        if (jokerRule) {
            long jokerCount = counted.getOrDefault('J', 0L);
            if (jokerCount != 5) {
                counted.remove('J');
                Character highestChar = Collections.max(counted.entrySet(), Map.Entry.comparingByValue()).getKey();
                counted.put(highestChar, counted.getOrDefault(highestChar, 0L) + jokerCount);
            }
        }
        if (counted.containsValue(5L)) {
            return 6;
        } else if (counted.containsValue(4L)) {
            return 5;
        } else if (counted.containsValue(3L) && counted.containsValue(2L)) {
            return 4;
        } else if (counted.containsValue(3L)) {
            return 3;
        } else if (counted.values()
                           .stream()
                           .collect(
                                   java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.counting())
                           ).getOrDefault(2L, 0L) == 2L) {
            return 2;
        } else if (counted.containsValue(2L)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Hand o) {
        if (this.type > o.type) {
            return 1;
        } else if (this.type < o.type) {
            return -1;
        }
        for (int i = 0; i < 5; i++) {
            List<Character> localCardValues = Hand.cardValues;
            if (this.jokerRule) {
                localCardValues = Hand.jokerCardValues;
            }
            if (localCardValues.indexOf(this.hand.charAt(i)) > localCardValues.indexOf(o.hand.charAt(i))) {
                return 1;
            } else if (localCardValues.indexOf(this.hand.charAt(i)) < localCardValues.indexOf(o.hand.charAt(i))) {
                return -1;
            }
        }
        return 0;
    }

    public static Hand fromLine(String line, boolean jokerRule) {
        String[] split = line.split(" ");
        return new Hand(split[0], Integer.parseInt(split[1]), jokerRule);
    }
}
