package day9;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import utils.FileLoader;

public class Day9 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Range> ranges = FileLoader.readFile("day9.txt").stream().map(Range::parseString).toList();
        System.out.println(getSumOfAllNextNumbers(ranges));
        System.out.println(getSumOfAllPreviousNumbers(ranges));
    }

    public static long getSumOfAllNextNumbers(List<Range> ranges) {
        return ranges.stream().mapToLong(Range::calculateNext).sum();
    }

    public static long getSumOfAllPreviousNumbers(List<Range> ranges) {
        return ranges.stream().mapToLong(Range::calculatePrevious).sum();
    }
}
