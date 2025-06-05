package ch.hslu.ad.D1_EX_ArrayListenQueueStack.queue;

public class Main {
    public static void main(String[] args) {
        MyQueueImplementation<Character> myQueue = new MyQueueImplementation<>(8);
        myQueue.enqueue('a');
        myQueue.enqueue('b');
        myQueue.enqueue('c');
        myQueue.enqueue('d');
        myQueue.enqueue('e');
        myQueue.enqueue('f');
        myQueue.enqueue('g');
        myQueue.enqueue('h');
        int size = myQueue.size();
        for (int i = 0; i < size; i++){
            System.out.println(myQueue.dequeue());
        }

        MyQueueImplementation<Character> myQueue2 = new MyQueueImplementation<>(8);
        myQueue2.enqueue('1');
        myQueue2.enqueue('2');
        myQueue2.enqueue('3');
        myQueue2.enqueue('4');
        myQueue2.enqueue('5');
        myQueue2.dequeue();
        size = myQueue2.size();
        for (int i = 0; i < size; i++){
            System.out.println(myQueue2.dequeue());
        }
    }
}
