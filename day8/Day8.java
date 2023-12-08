package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;

public class Day8 {

    public static int findShortestPath(List<Node> nodes, Node currentNode, String instruction, int result) {
        char[] instructions = instruction.toCharArray();
        for (char direction : instructions) {
            if (currentNode.getBase().equals("ZZZ")) {
                return result;
            }
            if (direction == 'L') {
                for (Node node : nodes) {
                    if (node.getBase().equals(currentNode.getLeft())) {
                        result++;
                        currentNode = node;
                        break;
                    }
                }
            }
            if (direction == 'R') {
                for (Node node : nodes) {
                    if (node.getBase().equals(currentNode.getRight())) {
                        result++;
                        currentNode = node;
                        break;
                    }
                }
            }
        }
        ;
        if (!currentNode.getBase().equals("ZZZ")) {
            System.out.println(result); // Part one = last step so with my input 15 964
            findShortestPath(nodes, currentNode, instruction, result);
        }
        return result;
    }

    private static long partTwo(Map<String, String[]> nodes, String instruction) {
        List<Integer> stepList = getPartTwoGhosts(nodes, instruction).stream()
                .mapToInt(ghost -> ghost.getStep()).boxed().toList();
        long total = stepList.get(0);
        for (int i = 1; i < stepList.size(); i++) {
            total = lcm(total, stepList.get(i));
            System.out.println(total);
        }
        return total;
    }

    private static Map<String, String[]> getNodeMap(List<Node> nodes) {
        Map<String, String[]> nodeMap = new TreeMap<>();
        for (Node node : nodes) {
            String[] elements = { node.getLeft(), node.getRight() };
            nodeMap.put(node.getBase(), elements);
        }
        return nodeMap;
    }

    private static List<Ghost> getPartTwoGhosts(Map<String, String[]> nodes, String instruction) {
        char[] instructions = instruction.toCharArray();
        List<String> startingNodes = nodes.keySet().stream().filter(node -> node.endsWith("A")).toList();
        return startingNodes.stream().map(node -> new Ghost(node, instructions, nodes)).toList();
    }

    private static long lcm(long x, long y) {
        long max = Math.max(x, y);
        long min = Math.min(x, y);
        long lcm = max;
        while (lcm % min != 0) {
            lcm += max;
        }
        return lcm;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "day8/input.txt";
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        List<Node> nodePartOne = new ArrayList<>();
        String instruction = lines.get(0) + lines.get(1);
        Pattern pattern = Pattern.compile("(\\w+)\\s+=\\s*\\(([^,]+),\\s*([^)]+)\\)");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                nodePartOne.add(new Node(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim()));
            }
        }
        // findShortestPath(nodePartOne, nodePartOne.get(427), instruction, 0);
        long partTwo = partTwo(getNodeMap(nodePartOne), instruction);
        // System.out.println("Part one : " + partOne);
        System.out.println("Part two : " + partTwo);
    }
}
