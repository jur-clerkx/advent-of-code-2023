import static day1.Day1.DIGIT_PATTERN;
import static day1.Day1.FULL_PATTERN;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import day1.Day1;
import day2.GameSet;

class Day2Test {
    @DisplayName("Day 1 a should correctly parse gameset part of input")
    @ParameterizedTest
    @CsvSource(value = { "'1 blue, 2 green',-1,2,1", "'3 green, 4 blue, 1 red',1,3,4", "'1 green, 1 blue',-1,1,1"})
    void shouldCorrectlyParseGameSets(String line, int red, int green, int blue) {
        GameSet gameSet = new GameSet(line);
        assertThat(gameSet.red).isEqualTo(red);
        assertThat(gameSet.green).isEqualTo(green);
        assertThat(gameSet.blue).isEqualTo(blue);
    }
}
