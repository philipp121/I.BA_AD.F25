package ch.hslu.ad.D1_EX_ArrayListenQueueStack.stack;

/**
 * A generic stack interface for storing and retrieving elements
 * in a Last-In-First-Out (LIFO) manner.
 *
 * <p>Implementations of this interface are expected to support
 * {@code push} and {@code pop} operations.</p>
 *
 * <p>This interface supports generic types, so it can be used
 * with any reference type.</p>
 *
 * @param <T> the type of elements stored in the stack
 */
public interface MyStack<T> {

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param value the element to be added to the stack
     */
     void push (T value);

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
     T pop();
}
