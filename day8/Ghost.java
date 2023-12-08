package day8;

import java.util.Map;

public class Ghost {

    private String currentNode;
    private char[] instructions;
    private Map<String, String[]> nodeMap;
    private int instructionCounter = 0;

    public Ghost(String currentNode, char[] instructions, Map<String, String[]> nodeMap) {
        this.currentNode = currentNode;
        this.instructions = instructions;
        this.nodeMap = nodeMap;
    }

    private void run() {
        char instruction = instructions[instructionCounter];
        int direction = instruction == 'L' ? 0 : 1;
        currentNode = nodeMap.get(currentNode)[direction];
        instructionCounter = (instructionCounter + 1) % instructions.length;
    }

    public int getStep() {
        int steps = 0;
        while (!done()) {
            run();
            steps++;
        }
        return steps;
    }

    private boolean done() {
        return currentNode.endsWith("Z");
    }

}
