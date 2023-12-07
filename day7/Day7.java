package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day7 {

    public static long Result(List<Hand> hands) {
        Collections.sort(hands);
        long sum = 0;
        long rank = hands.size();
        for (Hand h : hands) {
            sum += h.bid * rank--;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "day7/input.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        List<Hand> handPartOne = new ArrayList<>();
        List<Hand> handPartTwo = new ArrayList<>();

        for (String line : lines) {
            String cards = line.split(" ")[0];
            String bid = line.split(" ")[1];
            handPartOne.add(new Hand(cards, bid, false));
            handPartTwo.add(new Hand(cards, bid, true));
        }

        Collections.sort(handPartOne);
        long partOne = Result(handPartOne);
        long partTwo = Result(handPartTwo);
        System.out.println("Part one : " + partOne);
        System.out.println("Part two : " + partTwo);
    }
}
