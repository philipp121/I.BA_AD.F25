package ch.hslu.ad.D1_EX_ArrayListenQueueStack.queue;

public interface MyQueue<T> {
    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
    int size();
}
