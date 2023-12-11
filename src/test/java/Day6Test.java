import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import day6.Race;

class Day6Test {


    @Test
    void shouldResultIn4() {
        Race race = new Race(7,9);
        assertThat(race.getNumberOfWinningCombinations()).isEqualTo(4);
    }

    @Test
    void shouldResultIn8() {
        Race race = new Race(15,40);
        assertThat(race.getNumberOfWinningCombinations()).isEqualTo(8);
    }

    @Test
    void shouldResultIn9() {
        Race race = new Race(30,200);
        assertThat(race.getNumberOfWinningCombinations()).isEqualTo(9);
    }
}
