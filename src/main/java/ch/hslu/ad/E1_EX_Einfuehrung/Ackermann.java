package ch.hslu.ad.E1_EX_Einfuehrung;

public class Ackermann {
    public int aufrufe = 0;
    public static void main(String[] args) {
        Ackermann a = new Ackermann();
        System.out.println("ack(0, 4) = " + a.ack(0, 4) + " | Aufrufe: " + a.aufrufe); // 5
        a.aufrufe = 0;
        System.out.println("ack(1, 2) = " + a.ack(1, 2) + " | Aufrufe: " + a.aufrufe); // 4
        a.aufrufe = 0;
        System.out.println("ack(2, 2) = " + a.ack(2, 2) + " | Aufrufe: " + a.aufrufe); // 7

    }

    public long ack(long n, long m){
        aufrufe++;
        if (n == 0) {
            return m + 1;
        } else if (m == 0) {
            return ack(n - 1, 1);
        } else {
            return ack(n - 1, ack(n, m - 1));
        }
    }
}
