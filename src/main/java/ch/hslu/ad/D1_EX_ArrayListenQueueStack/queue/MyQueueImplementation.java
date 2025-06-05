package ch.hslu.ad.D1_EX_ArrayListenQueueStack.queue;

import java.util.NoSuchElementException;

public class MyQueueImplementation<T> implements MyQueue<T>{

    private final T[] data;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyQueueImplementation(int size){
        data = (T[]) new Object[size];
    }
    @Override
    public void enqueue(T value) {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("Queue is empty");
        T value = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
