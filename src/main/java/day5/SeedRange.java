package day5;

import java.util.*;

public record SeedRange (long start, long size) {

    public boolean inRange(long value) {
        return value >= start && value < start + size;
    }

    public static List<SeedRange> fromLine(String line) {
        List<Long> numbers = Arrays.stream(line.substring(7).split(" ")).mapToLong(Long::parseLong).boxed().toList();
        Long first = null;
        List<SeedRange> result = new ArrayList<>();
        for (Long number : numbers) {
            if (first == null) {
                first = number;
            } else {
                result.add(new SeedRange(first, number));
                first = null;
            }
        }
        return result;
    }
}
