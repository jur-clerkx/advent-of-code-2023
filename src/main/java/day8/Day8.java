package day8;

import static com.google.common.math.LongMath.gcd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.FileLoader;

public class Day8 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> lines = FileLoader.readFile("day8.txt");
        String instructions = lines.getFirst();
        Map<String, Node> nodes = lines.subList(2, lines.size()).stream().map(Node::parse).collect(Collectors.toMap(Node::name, n -> n));
        System.out.println(getSteps(instructions, nodes));
        System.out.println(getSteps2(instructions, nodes));
    }

    public static int getSteps(String instructions, Map<String, Node> nodes) {
        int steps = 0;
        int index = 0;
        Node currentNode = nodes.get("AAA");
        while (true) {
            steps++;
            if (index >= instructions.length()) {
                index = 0;
            }
            Character lr = instructions.charAt(index);
            index++;
            if (lr == 'L') {
                currentNode = nodes.get(currentNode.left());
            } else {
                currentNode = nodes.get(currentNode.right());
            }
            if (currentNode.name().equals("ZZZ")) {
                return steps;
            }
        }
    }

    public static long getSteps2(String instructions, Map<String, Node> nodes) {
        List<NodeNavigator> navigators = nodes.keySet().stream().filter(k -> k.endsWith("A"))
                .map(k -> new NodeNavigator(instructions, nodes.get(k), nodes)).toList();
        for (NodeNavigator navigator : navigators) {
            while (!navigator.isAtEnd()) {
                navigator.step();
            }
        }
        return lowestCommonMultiple(navigators.stream().mapToLong(NodeNavigator::getStep).toArray());
    }

    public static long lowestCommonMultiple(long[] stepArray) {
        long lcm = stepArray[0];
        for (int i = 1; i < stepArray.length; i++) {
            lcm = lcm(lcm, stepArray[i]);
        }
        return lcm;
    }

    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
}
