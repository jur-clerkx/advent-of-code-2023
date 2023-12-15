import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day9.Range;

class Day9Test {

    @Test
    @DisplayName("Correctly parse range string")
    void shouldCorrectlyParseRangeString(){
        List<Integer> expected = List.of(-1, 0, 2, 5, 9, 14);
        assertThat(Range.parseString("-1 0 2 5 9 14").numbers()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Correctly calculate next number")
    void shouldCorrectlyCalculateNextNumber(){
        Range range = Range.parseString("-1 0 2 5 9 14");
        assertThat(range.calculateNext()).isEqualTo(20);
    }

    @Test
    @DisplayName("Correctly calculate next number")
    void shouldCorrectlyCalculateNextNumber2(){
        Range range = Range.parseString("0 3 6 9 12 15");
        assertThat(range.calculateNext()).isEqualTo(18);
    }

    @Test
    @DisplayName("Correctly calculate next number")
    void shouldCorrectlyCalculateNextNumber3(){
        Range range = Range.parseString("1 3 6 10 15 21");
        assertThat(range.calculateNext()).isEqualTo(28);
    }


    @Test
    @DisplayName("Correctly calculate next number")
    void shouldCorrectlyCalculateNextNumber4(){
        Range range = Range.parseString("10 13 16 21 30 45");
        assertThat(range.calculateNext()).isEqualTo(68);
    }
}
