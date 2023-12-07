package day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import utils.FileLoader;

public class Day3 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> lines = FileLoader.readFile("day3.txt");
        AtomicInteger partsIndex = new AtomicInteger(0);
        List<Part> parts = lines.stream().map(line -> Part.fromLine(line, partsIndex.getAndIncrement())).flatMap(List::stream).toList();
        AtomicInteger symbolsIndex = new AtomicInteger(0);
        List<Symbol> symbols = lines.stream().map(line -> Symbol.fromLine(line, symbolsIndex.getAndIncrement())).flatMap(List::stream).toList();

        System.out.println("Day 3 a: " + sumOfPartsTouchingSymbols(parts, symbols));
        System.out.println("Day 3 b: " + powerOfGears(parts, symbols));
    }

    public static long sumOfPartsTouchingSymbols(List<Part> parts, List<Symbol> symbols) {
        return parts.stream().filter(part -> symbols.stream().anyMatch(symbol -> symbol.touches(part))).mapToInt(Part::value).sum();
    }

    public static long powerOfGears(List<Part> parts, List<Symbol> symbols) { // Gear is a two digit part touching a * symbol
        return symbols.stream().mapToInt(symbol -> symbol.gearRatio(parts)).sum();
    }
}
