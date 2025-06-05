package ch.hslu.ad.D1_EX_ArrayListenQueueStack.stack;

import java.util.NoSuchElementException;

public class MyStackImplementation<T> implements MyStack<T>{

    private final T[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStackImplementation(int size){
        data = (T[]) new Object[size];
        top = 0;
    }

    @Override
    public void push(T value) {
        if (top == data.length) {
            throw new StackOverflowError("Stack full");
        }
        data[top++] = value;
    }

    @Override
    public T pop() {
        if (top == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        T value = data[--top];
        data[top] = null;
        return value;
    }

    public int size(){
        return data.length;
    }
}
