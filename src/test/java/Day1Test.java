import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static day1.Day1.DIGIT_PATTERN;
import static day1.Day1.FULL_PATTERN;
import static org.assertj.core.api.Assertions.*;

import day1.Day1;

class Day1Test {
    @DisplayName("Day 1 a should correctly parse first and last int from line together")
    @ParameterizedTest
    @CsvSource({ "1abc2,12", "pqr3stu8vwx,38", "a1b2c3d4e5f,15", "treb7uchet, 77" })
    void shouldCorrectlyParseLines(String line, int result) {
        assertThat(Day1.getNumberCombinationFromLine(line, DIGIT_PATTERN)).isEqualTo(result);
    }

    @DisplayName("Day 1 a should correctly parse first and last int or written number from line together")
    @ParameterizedTest
    @CsvSource({ "two1nine,29", "eightwothree,83", "abcone2threexyz,13", "zoneight234, 14" })
    void shouldCorrectlyParseFullLines(String line, int result) {
        assertThat(Day1.getNumberCombinationFromLine(line, FULL_PATTERN)).isEqualTo(result);
    }
}
