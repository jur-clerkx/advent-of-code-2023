import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day3.Part;
import day3.Symbol;

class Day3Test {

    @DisplayName("Day 3 a part should correctly parse line")
    @Test
    void shouldCorrectlyParseLineToParts() {
        String line = "467..114..";
        List<Part> parts = Part.fromLine(line, 1);
        assertThat(parts).hasSize(2);
        Part part1 = parts.get(0);
        Part part2 = parts.get(1);

        assertThat(part1.xRange()).containsExactly(0, 1, 2);
        assertThat(part1.y()).isEqualTo(1);
        assertThat(part1.value()).isEqualTo(467);

        assertThat(part2.xRange()).containsExactly(5,6,7);
        assertThat(part2.y()).isEqualTo(1);
        assertThat(part2.value()).isEqualTo(114);

    }

    @DisplayName("Day 3 a part should correctly parse symbols")
    @Test
    void shouldCorrectlyParseLineToSymbols() {
        String lines = "617*......";
        List<Symbol> symbols = Symbol.fromLine(lines, 1);
        assertThat(symbols).hasSize(1);
        Symbol symbol = symbols.get(0);
        assertThat(symbol.x()).isEqualTo(3);
        assertThat(symbol.y()).isEqualTo(1);
        assertThat(symbol.value()).isEqualTo('*');
    }
}
