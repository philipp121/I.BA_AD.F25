package ch.hslu.ad.E1_EX_Einfuehrung;


import java.util.concurrent.ThreadLocalRandom;

public class Ggt {

    public int stepCounter = 0;

    public static void main(String[] args) {

        Ggt ggt = new Ggt();

        int a = ThreadLocalRandom.current().nextInt(10_000, 100_000);
        int b = ThreadLocalRandom.current().nextInt(1, a);

        long start = System.nanoTime();
        ggt.ggtIterativ1(a, b);
        long end = System.nanoTime();
        System.out.println("Steps ggtIterativ1: " + ggt.stepCounter);
        System.out.println("Time ggtIterativ1: " + (end - start) + " ns");
        ggt.stepCounter = 0;

        start = System.nanoTime();
        ggt.ggtIterativ2(a, b);
        end = System.nanoTime();
        System.out.println("Steps ggtIterativ2: " + ggt.stepCounter);
        System.out.println("Time ggtIterativ2: " + (end - start) + " ns");
        ggt.stepCounter = 0;

        start = System.nanoTime();
        ggt.ggtRekursiv(a, b);
        end = System.nanoTime();
        System.out.println("Steps ggtRekursiv: " + ggt.stepCounter);
        System.out.println("Time ggtRekursiv: " + (end - start) + " ns");
        ggt.stepCounter = 0;

    }

    public int ggtIterativ1(int a, int b) {
        while (a != b) {
            stepCounter++;
            if (a > b) {
                stepCounter++;
                stepCounter++;
                a = a - b;
            } else {
                stepCounter++;
                stepCounter++;
                b = b - a;
            }
        }
        stepCounter++;
        stepCounter++;
        return a;
    }

    public int ggtIterativ2(int a, int b) {
        while ((a != 0) && (b != 0)) {
            stepCounter++;
            stepCounter++;
            if (a > b) {
                stepCounter++;
                stepCounter++;
                a = a % b;
            } else {
                stepCounter++;
                stepCounter++;
                b = b % a;
            }
        }
        stepCounter++;
        stepCounter++;
        return a + b;
    }

    public int ggtRekursiv(int a, int b) {
        if (a > b) {
            stepCounter++;
            stepCounter++;
            return ggtRekursiv(a - b, b);
        } else {
            stepCounter++;
            stepCounter++;
            if (a < b) {
                stepCounter++;
                stepCounter++;
                return ggtRekursiv(a, b - a);
            } else {
                stepCounter++;
                stepCounter++;
                return a;
            }
        }
    }

}
