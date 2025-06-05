package ch.hslu.ad.D1_EX_ArrayListenQueueStack.stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackImplementationTest {

    @Test
    void MyStackIsEmpty() {
        MyStackImplementation myStack = new MyStackImplementation(1);
        assertThrowsExactly(NoSuchElementException.class, myStack::pop);
    }

    @Test
    void AddToStack() {
        MyStackImplementation myStack = new MyStackImplementation(1);
        myStack.push("firstString");
        assertEquals("firstString", myStack.pop());
    }

    @Test
    void StackIsFull(){
        MyStackImplementation myStack = new MyStackImplementation(1);
        myStack.push("firstString");
        assertThrowsExactly(StackOverflowError.class, () -> myStack.push("secondString"));
    }

    @Test
    void takeFromStack(){
        MyStackImplementation myStack = new MyStackImplementation(3);
        myStack.push("firstString");
        myStack.push("secondString");
        myStack.push("thirdString");

        assertEquals("thirdString", myStack.pop());
        assertEquals("secondString", myStack.pop());
        assertEquals("firstString", myStack.pop());

    }

}