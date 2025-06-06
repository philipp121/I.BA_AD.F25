package ch.hslu.ad.D1_EX_ArrayListenQueueStack.list;

import java.util.Objects;

public final class Node<T> {
    public final T value;
    public Node<T> next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
