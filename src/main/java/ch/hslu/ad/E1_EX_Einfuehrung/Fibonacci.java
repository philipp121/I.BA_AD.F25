package ch.hslu.ad.E1_EX_Einfuehrung;

public class Fibonacci {

    public static void main(String[] args) {

        int n = 150;

        long start = System.nanoTime();
        //System.out.println(n + ". Fibonacci Number: " +  fiboRec1(n));
        long end = System.nanoTime();
        System.out.println("n = " + n + " → duration: " + (end - start) + " ns");

        start = System.nanoTime();
        System.out.println(n + ". Fibonacci Number: " +  fiboRec2(n, new Long[n + 1]));
        end = System.nanoTime();
        System.out.println("n = " + n + " → duration: " + (end - start) + " ns");

        start = System.nanoTime();
        System.out.println(n + ". Fibonacci Number: " +  fiboIter(n));
        end = System.nanoTime();
        System.out.println("n = " + n + " → duration: " + (end - start) + " ns");
    }


    public static int fiboRec1(int n){
        if (n == 0) return 0; // Rekursionsbasis: F(0) = 0
        if (n == 1) return 1; // Rekursionsbasis: F(1) = 1
        return fiboRec1(n-1) + fiboRec1(n-2); // Rekursionsvorschrift: F(n) = F(n - 1) + F(n - 2)
    }

    public static int fiboRec2(int n, Integer[] f){
        if (n == 0) return 0; // Rekursionsbasis: F(0) = 0
        if (n == 1) return 1; // Rekursionsbasis: F(1) = 1
        if (f[n] != null) return f[n];
        f[n] = fiboRec2(n-1, f) + fiboRec2(n-2, f); // Rekursionsvorschrift: F(n) = F(n - 1) + F(n - 2)
        return f[n];
    }

    public static long fiboRec2(int n, Long[] f) {
        if (n == 0) return 0L; // Rekursionsbasis: F(0) = 0
        if (n == 1) return 1L; // Rekursionsbasis: F(1) = 1
        if (f[n] != null) return f[n];

        f[n] = fiboRec2(n - 1, f) + fiboRec2(n - 2, f); // Rekursionsvorschrift: F(n) = F(n - 1) + F(n - 2)
        return f[n];
    }

    public static long fiboIter(int n) {
        long a = 0; // F(0)
        long b = 1; // F(1)
        if (n == 0) return a;
        if (n == 1) return b;

        for (int i = 2; i <= n; i++) {
            long next = a + b; // F(n) = F(n-1) + F(n-2)
            a = b;
            b = next;
        }
        return b;
    }

}
