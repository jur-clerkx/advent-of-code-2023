package day2;

public class GameSet {

    public int red = -1;
    public int green = -1;
    public int blue = -1;

    public GameSet (String line) { // Line example: "3 green, 4 blue, 1 red"
        String[] parts = line.split(", ");
        for (String part : parts) {
            String[] subparts = part.split(" ");
            int number = Integer.parseInt(subparts[0]);
            String color = subparts[1];
            switch (color) {
                case "red":
                    this.red = number;
                    break;
                case "green":
                    this.green = number;
                    break;
                case "blue":
                    this.blue = number;
                    break;
            }
        }
    }

    public boolean isValid(int maxRed, int maxGreen, int maxBlue) {
        return (this.red <= maxRed && this.green <= maxGreen && this.blue <= maxBlue);
    }
}
