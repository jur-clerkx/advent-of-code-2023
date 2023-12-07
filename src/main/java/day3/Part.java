package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public record Part(List<Integer> xRange, int y, int value) {
    public static final Pattern PART_PATTERN = Pattern.compile("\\d+");

    public static List<Part> fromLine(String line, int y) {
        Matcher matcher = PART_PATTERN.matcher(line);
        return matcher.results().map(x -> {
            List<Integer> xRange = new ArrayList<>();
            IntStream.range(matcher.start(), matcher.end()).forEach(xRange::add);
            return new Part(xRange, y, Integer.parseInt(matcher.group()));
        }).toList();
    }
}
