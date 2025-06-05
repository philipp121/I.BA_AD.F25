package ch.hslu.ad.D1_EX_ArrayListenQueueStack.stack;

public class Main {
    public static void main(String[] args) {
        MyStackImplementation<String> myStack = new MyStackImplementation<>(3);
        myStack.push("toll");
        myStack.push("sind");
        myStack.push("Datenstrukturen");

        for (int i = 0; i < myStack.size(); i++){
            System.out.print(myStack.pop());
            System.out.print(" ");
        }
    }
}
