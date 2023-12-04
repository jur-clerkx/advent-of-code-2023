package day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.FileLoader;

public class Day1 {
    public static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    public static final Pattern FULL_PATTERN = Pattern.compile("(?=(\\d|one|two|three|four|five|six|seven|eight|nine))");

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> lines = FileLoader.readFile("day1.txt");
        System.out.println(getTotalFromLines(lines, DIGIT_PATTERN));
        System.out.println(getTotalFromLines(lines, FULL_PATTERN));
    }

    public static int getTotalFromLines(List<String> lines, Pattern pattern) {
        return lines.stream().map(x -> getNumberCombinationFromLine(x, pattern)).mapToInt(Integer::intValue).sum();
    }

    public static int getNumberCombinationFromLine(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        String firstDigit = replaceWrittenNumberByDigits(matcher.group(matcher.groupCount()));
        String lastDigit = firstDigit;
        while (matcher.find())
            lastDigit = replaceWrittenNumberByDigits(matcher.group(matcher.groupCount()));
        return Integer.parseInt(firstDigit + lastDigit);
    }

    public static String replaceWrittenNumberByDigits(String number) {
        String result = number.replace("one", "1");
        result = result.replace("two", "2");
        result = result.replace("three", "3");
        result = result.replace("four", "4");
        result = result.replace("five", "5");
        result = result.replace("six", "6");
        result = result.replace("seven", "7");
        result = result.replace("eight", "8");
        return result.replace("nine", "9");
    }
}