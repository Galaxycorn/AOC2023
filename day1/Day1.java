package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    private static Map<String, String> inputMap = new HashMap<String, String>() {
        {
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
            put("twone", "21");
            put("eightwo", "82");
        }
    };

    public int PartOne() {
        int sum = 0;
        try {
            File input = new File("day1\\input.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                List<String> numbers = new ArrayList<>();
                String lineInput = reader.nextLine();
                Pattern digitRegex = Pattern.compile("\\d");
                Matcher findNumber = digitRegex.matcher(lineInput);
                while (findNumber.find()) {
                    numbers.add(findNumber.group());
                }
                String value = numbers.get(0) + numbers.get(numbers.size() - 1);
                sum += Integer.parseInt(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return sum;
    }

    public int PartTwo() {

        int sum = 0;
        try {
            File input = new File("day1\\input.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String lineInput = reader.nextLine();
                String regexDigit = "(0|1|2|3|4|5|6|7|8|9|one|two|three|four|five|six|seven|eight|nine)";
                Pattern digitRegex1 = Pattern
                        .compile(regexDigit);
                Pattern digitRegex2 = Pattern.compile(".*" + regexDigit);
                char[] digits = new char[2];
                digits[0] = getDigit(lineInput, digitRegex1);
                digits[1] = getDigit(lineInput, digitRegex2);
                sum += Integer.valueOf(String.valueOf(digits));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return sum;
    }

    public char getDigit(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println(matcher.group());
            String digit = matcher.group(1);
            if (digit.length() == 1) {
                return digit.charAt(0);
            } else {
                return inputMap.get(digit).charAt(0);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println("Part one :" + day1.PartOne());
        System.out.println("Part two : " + day1.PartTwo());
    }

}