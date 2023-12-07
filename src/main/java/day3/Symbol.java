package day3;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public record Symbol(int x, int y, Character value) {
    public static final Pattern SYMBOL_PATTERN = Pattern.compile("[^.0-9]");
    public static List<Symbol> fromLine(String line, int y) {
        return SYMBOL_PATTERN.matcher(line).results().map(matchResult -> new Symbol(matchResult.start(), y, matchResult.group().charAt(0))).toList();
    }

    public boolean touches(Part part) {
        return IntStream.rangeClosed(this.x-1, this.x+1)
                .anyMatch(x -> IntStream.rangeClosed(this.y - 1, this.y + 1)
                        .anyMatch(y -> part.xRange().contains(x) && part.y() == y)
                );
    }

    public int gearRatio(List<Part> parts) {
        if (this.value == '*'  && parts.stream().filter(this::touches).toList().size() == 2) {
            List<Part> touching =  parts.stream().filter(this::touches).toList();
            return touching.get(0).value() * touching.get(1).value();
        } else {
            return 0;
        }
    }

}
