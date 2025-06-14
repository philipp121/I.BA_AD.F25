package ch.hslu.ad.A2_EX_Sortieren2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(ch.hslu.ad.A2_EX_Sortieren2.SortingPerformance.class);
    public static void main(String[] args) {
        int size = 1_000_000;
        final int passes = 5;

        double sumMixed = 0;
        SortingLibrary.quickSort(Main.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = Main.getShuffledNumbers(size);
            sumMixed += SortingLibrary.quickSort(a);
        }

        LOG.info("Quicksort with {} mixed Numbers average test duration = {} ms", size, sumMixed / (float) passes);

        size = 2_000_000;
        sumMixed = 0;
        SortingLibrary.quickSort(Main.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = Main.getShuffledNumbers(size);
            sumMixed += SortingLibrary.quickSort(a);
        }

        LOG.info("Quicksort with {} mixed Numbers average test duration = {} ms", size, sumMixed / (float) passes);

        size = 4_000_000;
        sumMixed = 0;
        SortingLibrary.quickSort(Main.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = Main.getShuffledNumbers(size);
            sumMixed += SortingLibrary.quickSort(a);
        }

        LOG.info("Quicksort with {} mixed Numbers average test duration = {} ms", size, sumMixed / (float) passes);
    }
}
