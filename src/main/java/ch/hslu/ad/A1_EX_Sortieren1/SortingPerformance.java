package ch.hslu.ad.A1_EX_Sortieren1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingPerformance {
    private static final Logger LOG = LoggerFactory.getLogger(SortingPerformance.class);
    public static void main(String[] args) {
        final int size = 10_000;
        final int passes = 5;

        double sumMixed = 0;
        SortingLibrary2.insertionSort2(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getShuffledNumbers(size);
            sumMixed += SortingLibrary2.insertionSort2(a);
        }

        double sumAsc = 0;
        SortingLibrary2.insertionSort2(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getAscendingNumbers(size);
            sumAsc += SortingLibrary2.insertionSort2(a);
        }

        double sumDesc = 0;
        SortingLibrary2.insertionSort2(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getDescendingNumbers(size);
            sumDesc += SortingLibrary2.insertionSort2(a);
        }

        LOG.info("Insertion Sort with mixed Numbers average test duration = {} ms", sumMixed / (float) passes);
        LOG.info("Insertion Sort with Ascending Numbers average test duration = {} ms", sumAsc / (float) passes);
        LOG.info("Insertion Sort with Descending Numbers average test duration = {} ms", sumDesc / (float) passes);

        sumMixed = 0;
        SortingLibrary2.selectionSort(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getShuffledNumbers(size);
            sumMixed += SortingLibrary2.selectionSort(a);
        }

        sumAsc = 0;
        SortingLibrary2.selectionSort(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getAscendingNumbers(size);
            sumAsc += SortingLibrary2.selectionSort(a);
        }

        sumDesc = 0;
        SortingLibrary2.selectionSort(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getDescendingNumbers(size);
            sumDesc += SortingLibrary2.selectionSort(a);
        }

        LOG.info("Selection Sort with mixed Numbers average test duration = {} ms", sumMixed / (float) passes);
        LOG.info("Selection Sort with Ascending Numbers average test duration = {} ms", sumAsc / (float) passes);
        LOG.info("Selection Sort with Descending Numbers average test duration = {} ms", sumDesc / (float) passes);

        sumMixed = 0;
        SortingLibrary2.bubbleSort(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getShuffledNumbers(size);
            sumMixed += SortingLibrary2.bubbleSort(a);
        }

        sumAsc = 0;
        SortingLibrary2.bubbleSort(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getAscendingNumbers(size);
            sumAsc += SortingLibrary2.bubbleSort(a);
        }

        sumDesc = 0;
        SortingLibrary2.bubbleSort(SortingMain.getShuffledNumbers(size));
        for (int i = 0; i < passes; i++) {
            int[] a = SortingMain.getDescendingNumbers(size);
            sumDesc += SortingLibrary2.bubbleSort(a);
        }

        LOG.info("Bubble Sort with mixed Numbers average test duration = {} ms", sumMixed / (float) passes);
        LOG.info("Bubble Sort with Ascending Numbers average test duration = {} ms", sumAsc / (float) passes);
        LOG.info("Bubble Sort with Descending Numbers average test duration = {} ms", sumDesc / (float) passes);
    }
}
