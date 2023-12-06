package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    public static int partOne(List<Integer> times, List<Integer> distances) {
        int result = 0;
        int counter = 0;
        List<Integer> possibilities = new ArrayList<>();
        for (int time : times) {
            int possibilitiy = 0;
            int distance = distances.get(counter);
            for (int i = 0; i < time; i++) {
                int possibleDistance = i * (time - i);
                if (possibleDistance > distance) {
                    possibilitiy++;
                }
            }
            possibilities.add(possibilitiy);
            counter++;
        }
        result = possibilities.stream().reduce(1, (a, b) -> a * b);
        return result;

    }

    public static long partTwo(List<Integer> times, List<Integer> distances) {
        long time = Long.parseLong(times.stream().map(Object::toString).collect(Collectors.joining("")));
        long distance = Long.parseLong(distances.stream().map(Object::toString).collect(Collectors.joining("")));
        long possibilities = 0;
        for (long i = 0; i < time; i++) {
            long possibleDistance = i * (time - i);
            if (possibleDistance > distance) {
                possibilities++;
            }
        }
        return possibilities;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "day6/input.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);

        List<Integer> times = new ArrayList<>();
        List<Integer> distances = new ArrayList<>();
        for (String line : lines) {
            System.out.println(line);
            if (line.startsWith("Time:")) {
                times = Arrays.stream(line.split("\\s+")).skip(1).map(Integer::parseInt).toList();
            }
            if (line.startsWith("Distance:")) {
                distances = Arrays.stream(line.split("\\s+")).skip(1).map(Integer::parseInt).toList();
            }
        }

        int partOne = partOne(times, distances);
        long sumPartTwo = partTwo(times, distances);
        System.out.println("Part One : " + partOne);
        System.out.println("Part Two : " + sumPartTwo);
    }

}
