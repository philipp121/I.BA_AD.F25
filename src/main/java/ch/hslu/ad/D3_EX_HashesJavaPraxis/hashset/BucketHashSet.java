package ch.hslu.ad.D3_EX_HashesJavaPraxis.hashset;

import ch.hslu.ad.D1_EX_ArrayListenQueueStack.list.Node;

import java.util.Arrays;

public class BucketHashSet {
    private Node<Integer>[] buckets;

    public BucketHashSet(int size) {
        buckets = new Node[size];
    }

    public boolean add(int value) {
        int index = findIndex(value);
        Node<Integer> current = buckets[index];
        while (current != null) {
            if (current.value == value) return false; // already exists
            current = current.next;
        }
        buckets[index] = new Node<>(value, buckets[index]); // prepend
        return true;
    }

    public boolean contains(int value) {
        int index = findIndex(value);
        Node<Integer> current = buckets[index];
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(int value) {
        int index = findIndex(value);
        Node<Integer> current = buckets[index];
        Node<Integer> prev = null;

        while (current != null) {
            if (current.value == value) {
                if (prev == null) {
                    // Remove first node in the list
                    buckets[index] = current.next;
                } else {
                    // Remove middle or last node
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            sb.append(String.format("Bucket %2d: ", i));
            Node current = buckets[i];
            if (current == null) {
                sb.append("empty");
            } else {
                while (current != null) {
                    sb.append(current.value).append(" -> ");
                    current = current.next;
                }
                sb.append("null");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int findIndex(int value){
        return Math.floorMod(Integer.hashCode(value), buckets.length);
    }

}
