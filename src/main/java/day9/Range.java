package day9;

import java.util.*;

public record Range(List<Integer> numbers) {

    public static Range parseString(String rangeString) {
        return new Range(Arrays.stream(rangeString.split(" ")).mapToInt(Integer::parseInt).boxed().toList());
    }

    public long calculateNext() {
        return getDifferenceForNext(this.numbers);
    }

    public long calculatePrevious() {
        return getDifferenceForPrevious(this.numbers);
    }

    public static long getDifferenceForNext(List<Integer> numbers) {
        List<Integer> nextNumbers = calculateNextNumberDiff(numbers);
        if (nextNumbers.stream().allMatch(n -> n == 0)) {
            return numbers.getLast();
        } else {
            return numbers.getLast() + getDifferenceForNext(nextNumbers);
        }
    }

    public static long getDifferenceForPrevious(List<Integer> numbers) {
        List<Integer> previousNumbers = calculateNextNumberDiff(numbers);
        if (previousNumbers.stream().allMatch(n -> n == 0)) {
            return numbers.getFirst();
        } else {
            return numbers.getFirst() - getDifferenceForPrevious(previousNumbers);
        }
    }

    public static List<Integer> calculateNextNumberDiff(List<Integer> numbers) {
        List<Integer> nextNumbers = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            nextNumbers.add(numbers.get(i) - numbers.get(i-1));
        }
        return nextNumbers;
    }
}
