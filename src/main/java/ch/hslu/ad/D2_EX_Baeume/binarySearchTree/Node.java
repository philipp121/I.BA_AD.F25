package ch.hslu.ad.D2_EX_Baeume.binarySearchTree;

import java.util.Objects;

public class Node implements Comparable<Node>{
    private Node left;
    private Node right;
    private int value;

    public Node(int value){
        this.value = value;
    }

    @Override
    public int compareTo(Node other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to null");
        }
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ch.hslu.ad.D1_EX_ArrayListenQueueStack.list.Node<?> node)) return false;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}
