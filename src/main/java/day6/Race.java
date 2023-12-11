package day6;

public record Race (long maxTime, long maxDistance){

    public int getNumberOfWinningCombinations() {
        int result = 0;
        for (int i = 0; i < maxTime; i++) {
            if ((this.maxTime - i) * i > maxDistance) {
                result++;
            }
        }
        return result;
    }
}
