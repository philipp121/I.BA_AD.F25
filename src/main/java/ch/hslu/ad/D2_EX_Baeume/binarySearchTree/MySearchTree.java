package ch.hslu.ad.D2_EX_Baeume.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MySearchTree implements MyTree{
    private Node root;
    private int size;

    @Override
    public Node search(int value) {
        return searchRecursive(root, value);
    }

    @Override
    public boolean add(Node node) {
        if (node == null) return false;

        // If root is null, insert as root
        if (root == null) {
            root = node;
            size++;
            return true;
        }

        // Otherwise delegate to recursive helper
        boolean inserted = addRecursive(root, node);
        if (inserted) size++;
        return inserted;
    }

    @Override
    public boolean remove(int value) {
        int initialSize = size;
        root = removeRecursive(root, value);
        return size < initialSize;
    }

    private Node searchRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.getValue()) {
            return current;
        }

        if (value < current.getValue()) {
            return searchRecursive(current.getLeft(), value);
        } else {
            return searchRecursive(current.getRight(), value);
        }
    }

    private boolean addRecursive(Node current, Node newNode) {
        int cmp = newNode.compareTo(current);

        if (cmp == 0) {
            // Duplicate value — not allowed
            return false;
        } else if (cmp < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return true;
            } else {
                return addRecursive(current.getLeft(), newNode);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
                return true;
            } else {
                return addRecursive(current.getRight(), newNode);
            }
        }
    }

    private Node removeRecursive(Node current, int value) {
        if (current == null) return null;

        if (value < current.getValue()) {
            current.setLeft(removeRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(removeRecursive(current.getRight(), value));
        } else {
            // Found the node to remove
            size--;

            // Case 1: no children
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // Case 2: one child
            if (current.getLeft() == null) return current.getRight();
            if (current.getRight() == null) return current.getLeft();

            // Case 3: two children → replace with inorder successor
            Node successor = findMin(current.getRight());
            current.setValue(successor.getValue());
            current.setRight(removeRecursive(current.getRight(), successor.getValue()));
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public int size(){
        return size;
    }

    public int height(){
        return heightRecursive(root);
    }

    private int heightRecursive(Node current) {
        if (current == null) return -1;

        int leftHeight = heightRecursive(current.getLeft());
        int rightHeight = heightRecursive(current.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(int value){
        return search(value) != null;
    }

    public List<Node> inOrder(){
        return inOrderRecursive(root);
    }

    private List<Node> inOrderRecursive(Node current) {
        List<Node> result = new ArrayList<>();

        if (current == null) {
            return result;
        }

        result.addAll(inOrderRecursive(current.getLeft()));
        result.add(current);
        result.addAll(inOrderRecursive(current.getRight()));

        return result;
    }
}
