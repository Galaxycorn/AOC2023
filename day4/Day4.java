package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    public static int partOne(List<String> input) {
        int sum = 0;
        for (String line : input) {
            Scratchcards card = findPoints(createCard(line));
            sum += card.getPoints();
        }
        return sum;
    }

    public static int partTwo(List<String> input) {
        List<Scratchcards> cards = new ArrayList<>();
        for (String line : input) {
            cards.add(findPoints(createCard(line)));
        }
        return findCopies(cards);
    }

    public static Scratchcards createCard(String line) {
        int id = 0;
        List<Integer> yourNumbers = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>();
        String idString = line.split(":")[0];
        line = line.split(":")[1];
        String yourNumbersInput = line.split("\\|")[1];
        String winningNumbersInput = line.split("\\|")[0];
        Pattern digitRegex = Pattern.compile("\\d+");
        Matcher findYourNumber = digitRegex.matcher(yourNumbersInput);

        while (findYourNumber.find()) {
            yourNumbers.add(Integer.parseInt(findYourNumber.group()));
        }

        Matcher findWinningNumber = digitRegex.matcher(winningNumbersInput);
        while (findWinningNumber.find()) {
            winningNumbers.add(Integer.parseInt(findWinningNumber.group()));
        }
        Matcher findId = digitRegex.matcher(idString);
        while (findId.find()) {
            id = Integer.parseInt(findId.group());
        }

        return new Scratchcards(yourNumbers, winningNumbers, id);
    }

    public static Scratchcards findPoints(Scratchcards card) {
        int counter = 0;
        for (int number : card.getYourNumbers()) {
            if (card.getWinningNumbers().contains(number))
                counter++;
        }
        if (counter > 0)
            card.setPoints(1 << counter - 1);
        card.setMatchingCounter(counter);
        return card;
    }

    public static int findCopies(List<Scratchcards> cards) {
        int[] copies = new int[cards.size()];
        Arrays.fill(copies, 1);
        for (int i = 0; i < copies.length; i++) {
            for (int j = 1; j <= cards.get(i).getMatchingCounter(); j++) {
                copies[i + j] += copies[i];
            }
        }
        return Arrays.stream(copies).sum();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "day4\\input.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);

        int partOne = partOne(lines);
        int sumPartTwo = partTwo(lines);
        System.out.println("Part One : " + partOne);
        System.out.println("Part Two : " + sumPartTwo);
    }
}
