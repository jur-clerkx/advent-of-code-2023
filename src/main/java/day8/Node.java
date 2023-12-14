package day8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Node(String name, String left, String right) {

    public static Node parse(String line) {
        Pattern pattern = Pattern.compile("([A-Z]+) = \\(([A-Z]+), ([A-Z]+)\\)");
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return new Node(matcher.group(1), matcher.group(2), matcher.group(3));
    }
}
