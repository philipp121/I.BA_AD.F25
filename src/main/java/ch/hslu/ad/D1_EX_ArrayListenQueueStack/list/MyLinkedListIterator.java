package ch.hslu.ad.D1_EX_ArrayListenQueueStack.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListIterator<T> implements Iterator<T> {

    private Node<T> current;

    public MyLinkedListIterator(Node<T> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (current == null) throw new NoSuchElementException();
        T value = current.value;
        current = current.next;
        return value;
    }
}
