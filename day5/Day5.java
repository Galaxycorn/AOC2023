package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {

    public static long partOne(BufferedReader br) throws IOException {
        // Map<String, List<List<Long>>> newMap = rangeMap(parsedData);
        // System.out.println("new map :" + newMap);
        // Set<String> keys = parsedData.keySet();
        // List<Long> seeds = newMap.get("seeds").get(0);

        // for (String key : keys) {
        // if (key.equals("seeds")) {
        // continue;
        // } else {
        // System.out.println("aled");
        // for (int j = 0; j < parsedData.get(key).size(); j++) {
        // maps.add(new Almanach(new Maps(parsedData.get(key).get(j).get(0),
        // parsedData.get(key).get(j).get(1),
        // parsedData.get(key).get(j).get(2))));
        // }
        // }
        // }

        List<Almanach> maps = new ArrayList<>();
        String line = br.readLine().substring("seeds: ".length());
        List<Long> seeds = Arrays.stream(line.split(" ")).map(Long::parseLong).toList();
        Almanach current = null;

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                if (current != null) {
                    maps.add(current);
                }
                line = br.readLine();
                current = new Almanach();
            } else {
                current.addMap(line.split(" "));
            }
        }
        maps.add(current);

        long min = Long.MAX_VALUE;
        for (Long number : seeds) {
            long res = number;
            for (Almanach map : maps) {
                res = map.map(res);
            }
            min = Math.min(min, res);
        }
        return min;
    }

    // public static Map<String, List<List<Long>>> rangeMap(Map<String,
    // List<List<Long>>> parsedData) {
    // Map<String, List<List<Long>>> newMap = new LinkedHashMap<>();
    // Set<String> keys = parsedData.keySet();
    // for (String key : keys) {
    // List<List<Long>> range = new ArrayList<>();
    // range.clear();
    // if (key.equals("seeds")) {
    // newMap.put(key, parsedData.get(key));
    // } else {
    // for (int j = 0; j < parsedData.get(key).size(); j++) {
    // List<Long> destination = new ArrayList<>();
    // List<Long> source = new ArrayList<>();
    // destination.add(parsedData.get(key).get(j).get(0) +
    // parsedData.get(key).get(j).get(2));
    // source.add(parsedData.get(key).get(j).get(1) +
    // parsedData.get(key).get(j).get(2));

    // // System.out.println(destination);
    // // System.out.println(source);
    // range.add(source);
    // range.add(destination);
    // }
    // newMap.put(key, range);
    // }
    // }
    // System.out.println(newMap);
    // return newMap;
    // }

    // public static Map<String, List<List<Long>>> parseData(String fileName) throws
    // IOException {
    // Map<String, List<List<Long>>> parsedData = new LinkedHashMap<>();
    // BufferedReader br = new BufferedReader(new FileReader(fileName));

    // String line;
    // List<Long> seeds = new ArrayList<>();
    // List<List<Long>> currentMap = null;

    // while ((line = br.readLine()) != null) {
    // line = line.trim();

    // if (line.startsWith("seeds:")) {
    // String[] seedValues = line.split(":")[1].trim().split(" ");
    // for (String seed : seedValues) {
    // seeds.add(Long.parseLong(seed));
    // }
    // parsedData.put("seeds", List.of(seeds));
    // } else if (line.endsWith("map:")) {
    // String mapName = line;
    // currentMap = new ArrayList<>();
    // parsedData.put(mapName, currentMap);
    // } else if (line.matches("\\d+.*")) {
    // String[] values = line.trim().split(" ");
    // List<Long> row = new ArrayList<>();
    // for (String value : values) {
    // row.add(Long.parseLong(value));
    // }
    // currentMap.add(row);
    // }
    // }

    // br.close();
    // return parsedData;
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day5/input.txt"));
        long partOne = partOne(br);
        // int sumPartTwo = partTwo(lines);
        System.out.println("Part One : " + partOne);
        // System.out.println("Part Two : " + sumPartTwo);
    }
}
