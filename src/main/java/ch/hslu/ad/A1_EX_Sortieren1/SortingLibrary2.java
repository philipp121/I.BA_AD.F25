package ch.hslu.ad.A1_EX_Sortieren1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingLibrary2 {

    private static final Logger LOG = LoggerFactory.getLogger(SortingLibrary2.class);

    public static double insertionSort(final int[] a){
        double start = System.nanoTime();
        int element;
        int j;
        for (int i = 1; i < a.length; i++) {
            element = a[i]; // store next element for insert
            j = i; // a[0]..a[j-1] already sorted
            while ((j > 0) && (a[j - 1] > element)) {
                a[j] = a[j - 1]; // shift right
                j--; // go further left
            }
            a[j] = element; // insert element
        } // a[0]...a[j] sorted
        double end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    public static double insertionSort2(final int[] array){
        double start = System.nanoTime();
        int[] a = growArrayWithLeadingSlot(array);
        int element;
        int j;
        for (int i = 1; i < a.length; i++) {
            element = a[i]; // store next element for insert
            a[0] = element; // dummy-element
            j = i; // a[0]..a[j-1] already sorted
            while ((a[j - 1] > element)) {
                a[j] = a[j - 1]; // shift right
                j--; // go further left
            }
            a[j] = element; // insert element
        } // a[0]...a[j] sorted

        int[] a_normalized = shrinkArrayByRemovingFirst(a);
        double end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    public static double selectionSort(int[] a){
        long start = System.nanoTime();
        for (int i = 0; i < a.length; i++){
            int minIndex = i;
            for (int j = i; j < a.length; j++){
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;

            }
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    public static double bubbleSort(int[] a){
        double start = System.nanoTime();
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length - 1 - i; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    private static int[] growArrayWithLeadingSlot(int[] original) {
        int[] extended = new int[original.length + 1];
        System.arraycopy(original, 0, extended, 1, original.length);
        return extended;
    }

    private static int[] shrinkArrayByRemovingFirst(int[] original) {
        if (original.length <= 1) {
            return new int[0]; // oder throw IllegalArgumentException
        }
        int[] smaller = new int[original.length - 1];
        System.arraycopy(original, 1, smaller, 0, smaller.length);
        return smaller;
    }
}
