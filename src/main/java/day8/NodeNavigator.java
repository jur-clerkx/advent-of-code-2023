package day8;

import java.util.List;
import java.util.Map;

public class NodeNavigator {
    private final String instructions;
    private final Node startNode;
    private final Map<String, Node> nodes;
    private Node currentNode;
    private int index;
    private int step;

    public NodeNavigator(String instructions, Node startNode, Map<String, Node> nodes) {
        this.instructions = instructions;
        this.startNode = startNode;
        this.currentNode = startNode;
        this.nodes = nodes;
        this.index = 0;
        this.step = 0;
    }

    public int getStep() {
        System.out.println(step);
        return step;
    }

    public void step() {
        if (index >= instructions.length()) {
            index = 0;
        }
        Character lr = instructions.charAt(index);
        index++;
        step++;
        if (lr == 'L') {
            currentNode = nodes.get(currentNode.left());
        } else {
            currentNode = nodes.get(currentNode.right());
        }
    }

    public boolean isAtEnd() {
        return currentNode.name().endsWith("Z");
    }
}
