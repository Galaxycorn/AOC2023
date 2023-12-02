package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

    public static int partOne(String line) {
        String regex = "(\\d+)\\s+(blue|red|green)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String number = matcher.group(1);
            String type = matcher.group(2);
            if (type.equals("red") && Integer.parseInt(number) > 12) {
                return 0;
            }
            if (type.equals("green") && Integer.parseInt(number) > 13) {
                return 0;
            }
            if (type.equals("blue") && Integer.parseInt(number) > 14) {
                return 0;
            }
        }
        return Integer.parseInt(line.split(":")[0].split(" ")[1]);
    }

    public static int partTwo(String line) {
        String regex = "(\\d+)\\s+(blue|red|green)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        int[] values = new int[3];

        while (matcher.find()) {
            String number = matcher.group(1);
            String type = matcher.group(2);
            if (type.equals("red")) {
                values[0] = Math.max(Integer.parseInt(number), values[0]);
            }
            if (type.equals("green")) {
                values[1] = Math.max(Integer.parseInt(number), values[1]);
            }
            if (type.equals("blue")) {
                values[2] = Math.max(Integer.parseInt(number), values[2]);
            }
        }

        return values[0] * values[1] * values[2];
    }

    public static void main(String[] args) throws IOException {
        String filePath = "day2\\input.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        int sumPartOne = 0;
        int sumPartTwo = 0;
        for (String line : lines) {
            sumPartOne += partOne(line);
            sumPartTwo += partTwo(line);
        }
        System.out.println("Part One : " + sumPartOne);
        System.out.println("Part Two : " + sumPartTwo);
    }
}
