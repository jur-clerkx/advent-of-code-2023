import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day3.Part;
import day3.Symbol;
import day4.Card;

class Day4Test {

    @DisplayName("5 winning numbers should result in 8")
    @Test
    void shouldResultInScore8() {
        String line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = Card.fromLine(line);
        assertThat(card.getScore()).isEqualTo(8);
    }

    @DisplayName("1 winning number should result in 1")
    @Test
    void shouldResultInScore1() {
        String line = "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83";
        Card card = Card.fromLine(line);
        assertThat(card.getScore()).isEqualTo(1);
    }

    @DisplayName("No winning number should result in 0")
    @Test
    void shouldResultInScore0() {
        String line = "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11";
        Card card = Card.fromLine(line);
        assertThat(card.getScore()).isEqualTo(0);
    }

    @DisplayName("2 winning numbers should result in 2")
    @Test
    void shouldResultInScore2() {
        String line = "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19";
        Card card = Card.fromLine(line);
        assertThat(card.getScore()).isEqualTo(2);
    }
}
