package ch.hslu.ad.D1_EX_ArrayListenQueueStack.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;


public class MyLinkedList<T> implements Collection<T> {
    public Node<T> head;
    private int size = 0;

    @Override
    public boolean  add(T value){
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o){
        for (T item : this) {
            if (Objects.equals(item, o)) return true;
        }
        return false;
    }

    public boolean removeHeadNode(){
        if (head == null) return false;
        size--;
        head = head.next;
        return true;
    }

    @Override
    public boolean remove(Object o){
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (Objects.equals(current.value, o)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator<>(head);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }
}
