package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PrimeCheckSingle {
    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheckSingle.class);
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 1;
        while (n <= 100) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info("{} : {}...", n, bi.toString().substring(0, 20));
                n++;
            }
        }
        long end = System.nanoTime();
        System.out.println("Gebrauchte Zeit in ms: " + TimeUnit.NANOSECONDS.toMillis((end - start)));
    }
}
