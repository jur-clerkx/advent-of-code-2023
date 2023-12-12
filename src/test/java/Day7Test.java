

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Day7.Hand;

class Day7Test {

    @DisplayName("5 of a kind")
    @Test
    void shouldBe5OfAKind() {
        Hand hand = new Hand("AAAAA", 1,false);
        assertThat(hand.getType()).isEqualTo(6);
    }

    @DisplayName("4 of a kind")
    @Test
    void shouldBe4OfAKind() {
        Hand hand = new Hand("AAAAK", 1,false);
        assertThat(hand.getType()).isEqualTo(5);
    }

    @DisplayName("Full House")
    @Test
    void shouldBeFullHouse() {
        Hand hand = new Hand("KKKAA", 1,false);
        assertThat(hand.getType()).isEqualTo(4);
    }

    @DisplayName("3 of a kind")
    @Test
    void shouldBe3OfAKind() {
        Hand hand = new Hand("KKKQJ", 1,false);
        assertThat(hand.getType()).isEqualTo(3);
    }

    @DisplayName("2 pairs")
    @Test
    void shouldBe2Pairs() {
        Hand hand = new Hand("KKQQJ", 1,false);
        assertThat(hand.getType()).isEqualTo(2);
    }

    @DisplayName("1 pair")
    @Test
    void shouldBe1Pair() {
        Hand hand = new Hand("KKQJ9", 1,false);
        assertThat(hand.getType()).isEqualTo(1);
    }

    @DisplayName("High card")
    @Test
    void shouldBeHighCard() {
        Hand hand = new Hand("KQJ98", 1,false);
        assertThat(hand.getType()).isEqualTo(0);
    }

    @DisplayName("Full house beats 3 of a kind")
    @Test
    void shouldBeFullHouseBeats3OfAKind() {
        Hand hand1 = new Hand("KKKAA", 1,false);
        Hand hand2 = new Hand("KKKQJ", 2,false);
        assertThat(hand1.compareTo(hand2)).isEqualTo(1);
    }

    @DisplayName("Same type should beat by first high card")
    @Test
    void shouldBeSameTypeBeatsByFirstHighCard() {
        Hand hand1 = new Hand("QQQAA", 1,false);
        Hand hand2 = new Hand("KKKJJ", 2,false);
        assertThat(hand1.compareTo(hand2)).isEqualTo(-1);
    }

    @DisplayName("Joker rule should upgrade three of a kind to 4 of a kind")
    @Test
    void shouldBeJokerRuleUpgradeThreeOfAKindToFourOfAKind() {
        Hand hand = new Hand("KKKJ9", 1,true);
        assertThat(hand.getType()).isEqualTo(5);
    }

    @DisplayName("Joker rule: highcard and 4 jokers upgrades to 5 of a kind")
    @Test
    void shouldBeJokerRuleHighCardAnd4JokersUpgradesTo5OfAKind() {
        Hand hand = new Hand("AJJJJ", 4,true);
        assertThat(hand.getType()).isEqualTo(6);
    }

    @DisplayName("Joker rule: highcard and 3 jokers upgrades to 4 of a kind")
    @Test
    void shouldBeJokerRuleHighCardAnd3JokersUpgradesTo4OfAKind() {
        Hand hand = new Hand("AJJJQ", 3,true);
        assertThat(hand.getType()).isEqualTo(5);
    }
}
