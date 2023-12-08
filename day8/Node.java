package day8;

public class Node {

    private String base;
    private String left;
    private String right;

    public Node(String base, String left, String right) {
        this.base = base;
        this.left = left;
        this.right = right;
    }

    public String getBase() {
        return this.base;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }

    public String toString() {
        return "Base : " + base + " left : " + left + " right " + right;
    }
}
