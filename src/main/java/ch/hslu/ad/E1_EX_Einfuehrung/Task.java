package ch.hslu.ad.E1_EX_Einfuehrung;

public class Task {

    public int task1;
    public int task2;
    public int task3;


    public static void main(String[] args) {
        Task t = new Task();
        long start = System.currentTimeMillis();
        t.task(10);
        long end = System.currentTimeMillis();
        System.out.println("Anzahl Task 1: " + t.task1 + " | Anzahl Task 2: " + t.task2 + " | Anzahl Task 3: " + t.task3);
        System.out.println("n = " + 10 + " → duration: " + (end - start) + " ms");
        t.reset();

        start = System.currentTimeMillis();
        t.task(20);
        end = System.currentTimeMillis();
        System.out.println("Anzahl Task 1: " + t.task1 + " | Anzahl Task 2: " + t.task2 + " | Anzahl Task 3: " + t.task3);
        System.out.println("n = " + 20 + " → duration: " + (end - start) + " ms");
        t.reset();

        start = System.currentTimeMillis();
        t.task(50);
        end = System.currentTimeMillis();
        System.out.println("Anzahl Task 1: " + t.task1 + " | Anzahl Task 2: " + t.task2 + " | Anzahl Task 3: " + t.task3);
        System.out.println("n = " + 50 + " → duration: " + (end - start) + " ms");
        t.reset();

        start = System.currentTimeMillis();
        t.task(100);
        end = System.currentTimeMillis();
        System.out.println("Anzahl Task 1: " + t.task1 + " | Anzahl Task 2: " + t.task2 + " | Anzahl Task 3: " + t.task3);
        System.out.println("n = " + 100 + " → duration: " + (end - start) + " ms");
        t.reset();
    }

    public void task(final int n) {
        task1(); task1(); task1(); task1();
        for (int i = 0; i < n; i++) {
            task2(); task2(); task2();
            for (int j = 0; j < n; j++) {
                task3(); task3();
            }
        }
    }

    public void reset(){
        task1 = 0;
        task2 = 0;
        task3 = 0;
    }

    public void task1(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task1++;
    }

    public void task2(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task2++;
    }

    public void task3(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task3++;
    }
}
