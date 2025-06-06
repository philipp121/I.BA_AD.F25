package ch.hslu.ad.D3_EX_HashesJavaPraxis.performance;

import ch.hslu.ad.D1_EX_ArrayListenQueueStack.stack.MyStackImplementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int testSize = 100_000;
        int amount = 10;
        List<Long> myStackTimes = new ArrayList<>();
        List<Long> stackTimes = new ArrayList<>();
        List<Long> dequeTimes = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            Character[] testData = generateCharArray(testSize);
            myStackTimes.add(performanceMyStack(testData, testSize, amount));
            stackTimes.add(performanceStack(testData, testSize, amount));
            dequeTimes.add(performanceDeque(testData, testSize, amount));
            testSize *= 10;
        }

        System.out.printf("%-12s %-18s %-18s %-18s %-12s %-12s%n",
                "Test Size",
                "MyStack Avg (ns)",
                "Java Stack Avg (ns)",
                "Java Deque Avg (ns)",
                "Stack↑",
                "Deque↑"
        );
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < myStackTimes.size(); i++) {
            long myTime = myStackTimes.get(i);
            long javaTime = stackTimes.get(i);
            long dequeTime = dequeTimes.get(i);

            double stackSpeedup = (double) javaTime / myTime;
            double dequeSpeedup = (double) dequeTime / myTime;

            System.out.printf(
                    "%-12d %-18d %-18d %-18d %-10s %-10s%n",
                    (int) Math.pow(10, 5 + i),
                    myTime,
                    javaTime,
                    dequeTime,
                    String.format("%.2fx", (double) javaTime / myTime),
                    String.format("%.2fx", (double) dequeTime / myTime)
            );
        }


    }
    public static long performanceDeque(Character[] testData, int testSize, int amount){
        Deque<Character> deque = new ArrayDeque<>(testSize);

        measureDeque(deque, testData); // dry run
        deque.clear();
        // GC warm-up
        System.gc();
        try {
            Thread.sleep(50); // let GC settle
        } catch (InterruptedException ignored) {}

        System.out.println("---------Java Stack with " + testSize + "---------");
        long sum = 0;
        for (int i = 0; i < amount; i++){
            long time = measureDeque(deque, testData);
            System.out.println("duration: " + time + " ns");
            sum += time;
            deque.clear();
        }
        long average = sum / amount;
        System.out.println("Java Stack Average: " + average + " ns");
        System.out.println("--------------------------------------------------");
        return average;
    }

    public static long measureDeque(Deque<Character> deque, Character[] testData){
        long start = System.nanoTime();
        for (Character c : testData){
            deque.push(c);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long performanceStack(Character[] testData, int testSize, int amount){
        Stack<Character> stack = new Stack<>();
        stack.ensureCapacity(10_000_000);

        measureStack(stack, testData); // dry run
        stack.empty();
        // GC warm-up
        System.gc();
        try {
            Thread.sleep(50); // let GC settle
        } catch (InterruptedException ignored) {}

        System.out.println("---------Java Stack with " + testSize + "---------");
        long sum = 0;
        for (int i = 0; i < amount; i++){
            long time = measureStack(stack, testData);
            System.out.println("duration: " + time + " ns");
            sum += time;
            stack.empty();
        }
        long average = sum / amount;
        System.out.println("Java Stack Average: " + average + " ns");
        System.out.println("--------------------------------------------------");
        return average;
    }

    public static long measureStack(Stack<Character> stack, Character[] testData){
        long start = System.nanoTime();
        for (Character c : testData){
            stack.push(c);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long performanceMyStack(Character[] testData, int testSize, int amount){
        MyStackImplementation<Character> myStack = new MyStackImplementation<>(testSize);

        measureMyStack(myStack, testData); // dry run
        myStack.empty();
        // GC warm-up
        System.gc();
        try {
            Thread.sleep(50); // let GC settle
        } catch (InterruptedException ignored) {}

        System.out.println("---------My Stack " + testSize + "---------");
        long sum = 0;
        for (int i = 0; i < amount; i++){
            long time = measureMyStack(myStack, testData);
            System.out.println("duration: " + time + " ns");
            sum += time;
            myStack.empty();
        }
        long average = sum / amount;
        System.out.println("My Stack Average: " + average + " ns");
        System.out.println("--------------------------------------------");
        return average;
    }

    public static long measureMyStack(MyStackImplementation<Character> myStack, Character[] testData){
        long start = System.nanoTime();
        for (Character c : testData){
            myStack.push(c);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static Character[] generateCharArray(int size) {
        Character[] data = new Character[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = (char) ('a' + r.nextInt(26));
        }
        return data;
    }
}
