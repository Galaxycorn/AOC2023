package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Day3 {

    public static int partOne(char[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                char currentChar = input[i][j];
                if (Character.isDigit(currentChar)) {
                    boolean toAdd = false;
                    StringBuilder number = new StringBuilder();
                    while (j < input[i].length && Character.isDigit(input[i][j])) {
                        if (isAdjacent(i, j, input))
                            toAdd = true;
                        number.append(input[i][j]);
                        j++;
                    }
                    if (toAdd)
                        sum += Integer.parseInt(number.toString());
                }
            }
        }
        return sum;
    }

    public static int partTwo(char[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                char currentChar = input[i][j];
                if (currentChar == '*') {
                    List<Integer> sumList = gearAdjacency(i, j, input);
                    if (sumList.size() > 1)
                        sum += sumList.get(0) * sumList.get(1);
                }
            }
        }
        return sum;
    }

    public static boolean isAdjacent(int x, int y, char[][] input) {
        int numRows = input.length;
        int numCols = input[0].length;

        if (y + 1 < numCols && !Character.isDigit(input[x][y + 1]) && !(input[x][y + 1] == '.')) {
            return true;
        }
        if (y - 1 >= 0 && !Character.isDigit(input[x][y - 1]) && !(input[x][y - 1] == '.')) {
            return true;
        }
        if (x + 1 < numRows && !Character.isDigit(input[x + 1][y]) && !(input[x + 1][y] == '.')) {
            return true;
        }
        if (x - 1 >= 0 && !Character.isDigit(input[x - 1][y]) && !(input[x - 1][y] == '.')) {
            return true;
        }
        if (x + 1 < numRows && y + 1 < numCols && !Character.isDigit(input[x + 1][y + 1])
                && !(input[x + 1][y + 1] == '.')) {
            return true;
        }
        if (x - 1 >= 0 && y + 1 < numCols && !Character.isDigit(input[x - 1][y + 1]) && !(input[x - 1][y + 1] == '.')) {
            return true;
        }
        if (x + 1 < numRows && y - 1 >= 0 && !Character.isDigit(input[x + 1][y - 1]) && !(input[x + 1][y - 1] == '.')) {
            return true;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && !Character.isDigit(input[x - 1][y - 1]) && !(input[x - 1][y - 1] == '.')) {
            return true;
        }

        return false;
    }

    public static List<Integer> gearAdjacency(int x, int y, char[][] input) {
        List<Integer> numbers = new ArrayList<Integer>();
        int numRows = input.length;
        int numCols = input[0].length;

        if (y + 1 < numCols && Character.isDigit(input[x][y + 1])) {
            numbers.add(getNumber(x, y + 1, input));
        }
        if (y - 1 >= 0 && Character.isDigit(input[x][y - 1])) {
            numbers.add(getNumber(x, y - 1, input));
        }
        if (x + 1 < numRows && Character.isDigit(input[x + 1][y])) {
            numbers.add(getNumber(x + 1, y, input));
        }
        if (x - 1 >= 0 && Character.isDigit(input[x - 1][y])) {
            numbers.add(getNumber(x - 1, y, input));
        }
        if (x + 1 < numRows && y + 1 < numCols && Character.isDigit(input[x + 1][y + 1])) {
            numbers.add(getNumber(x + 1, y + 1, input));
        }
        if (x - 1 >= 0 && y + 1 < numCols && Character.isDigit(input[x - 1][y + 1])) {
            numbers.add(getNumber(x - 1, y + 1, input));
        }
        if (x + 1 < numRows && y - 1 >= 0 && Character.isDigit(input[x + 1][y - 1])) {
            numbers.add(getNumber(x + 1, y - 1, input));
        }
        if (x - 1 >= 0 && y - 1 >= 0 && Character.isDigit(input[x - 1][y - 1])) {
            numbers.add(getNumber(x - 1, y - 1, input));
        }
        removeDuplicated(numbers);
        return numbers;
    }

    public static int getNumber(int x, int y, char[][] input) {
        int numberFound = 0;
        StringBuilder number = new StringBuilder();

        int left = y;
        while (left >= 0 && Character.isDigit(input[x][left])) {
            number.insert(0, input[x][left]);
            left--;
        }

        int right = y + 1;
        while (right < input[x].length && Character.isDigit(input[x][right])) {
            number.append(input[x][right]);
            right++;
        }

        numberFound = Integer.parseInt((y < left) ? number.reverse().toString() : number.toString());
        return numberFound;
    }

    public static List<Integer> removeDuplicated(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "day3\\input.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        char[][] inputArray = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            inputArray[i] = lines.get(i).toCharArray();
        }

        int sumPartOne = partOne(inputArray);
        int sumPartTwo = partTwo(inputArray);
        System.out.println("Part One : " + sumPartOne);
        System.out.println("Part Two : " + sumPartTwo);
    }
}
