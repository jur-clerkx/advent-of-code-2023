package day5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import utils.FileLoader;

public class Day5 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> lines = FileLoader.readFile("day5.txt");
        long[] seeds = parseSeeds(lines);
        List<ConversionGroup> conversionGroups = parseConversionMaps(lines);
        List<SeedRange> seedRanges = parseSeedRanges(lines);
        System.out.println(getLowestLocation(seeds, conversionGroups));
        System.out.println(getLowestLocationForRanges(seedRanges, conversionGroups));
    }

    public static long[] parseSeeds(List<String> lines) {
        String seedsLine = lines.stream().filter(line -> line.startsWith("seeds:")).toList().getFirst();
        return Arrays.stream(seedsLine.substring(7).split(" "))
                .map(String::trim)
                .mapToLong(Long::parseLong)
                .toArray();
    }

    public static List<ConversionGroup> parseConversionMaps(List<String> lines) {
        List<ConversionGroup> result = new ArrayList<>();
        List<String> mapLines = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank() && !mapLines.isEmpty()) {
                result.add(ConversionGroup.fromLines(mapLines));
                mapLines.clear();
            } else if (!line.contains("map:") && !line.contains("seeds:") && !line.isBlank()) {
                mapLines.add(line);
            }
        }
        result.add(ConversionGroup.fromLines(mapLines));
        return result;
    }

    public static List<SeedRange> parseSeedRanges(List<String> lines) {
        return lines.stream().filter(line -> line.startsWith("seeds:")).map(SeedRange::fromLine).toList().getFirst();
    }

    public static long getLowestLocation(long[] seeds, List<ConversionGroup> conversionGroups) {
        long lowestLocation = Long.MAX_VALUE;
        for (long seed : seeds) {
            long current = seed;
            for (ConversionGroup conversionGroup : conversionGroups) {
                current = conversionGroup.convertFromSourceToTarget(current);
            }
            if (current < lowestLocation) {
                lowestLocation = current;
            }
        }
        return lowestLocation;
    }

    public static long getLowestLocationForRanges(List<SeedRange> ranges, List<ConversionGroup> conversionGroups) {
        long location = 1;
        conversionGroups = conversionGroups.reversed();
        while(true) {
            long current = location;
            for (ConversionGroup conversionGroup : conversionGroups) {
                current = conversionGroup.convertFromTargetToSource(current);
            }
            long seed = current;
            if (ranges.stream().anyMatch(range -> range.inRange(seed))) {
                return location;
            }
            location++;
        }
    }
}
