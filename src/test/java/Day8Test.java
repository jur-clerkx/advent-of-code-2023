import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day8.Node;

class Day8Test {

    @Test
    @DisplayName("Should parse a line into a Node")
    void shouldParseLineIntoNode() {
        String line = "A = (B, C)";
        Node node = Node.parse(line);
        assertThat(node.name()).isEqualTo("A");
        assertThat(node.left()).isEqualTo("B");
        assertThat(node.right()).isEqualTo("C");
    }

    @Test
    @DisplayName("Should parse a line with multiple character names into a Node")
    void shouldParseLineWithMultipleCharacterNamesIntoNode() {
        String line = "AB = (CD, EF)";
        Node node = Node.parse(line);
        assertThat(node.name()).isEqualTo("AB");
        assertThat(node.left()).isEqualTo("CD");
        assertThat(node.right()).isEqualTo("EF");
    }
}
