package ch.hslu.ad.A1_EX_Sortieren1;

import ch.hslu.ad.A1_EX_Sortieren1.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SortingLibrary {

    private static final Logger LOG = LoggerFactory.getLogger(SortingLibrary.class);

    public static int [] insertionSort(final int[] a){
        long start = System.nanoTime();
        int delay = 10;
        int amountOfCompare = 0;
        int element;
        int j;
        for (int i = 1; i < a.length; i++) {
            element = a[i]; // store next element for insert
            j = i; // a[0]..a[j-1] already sorted
            while ((j > 0) && (a[j - 1] > element)) {
                amountOfCompare += 2;
                a[j] = a[j - 1]; // shift right
                j--; // go further left
                SortingAnimation.instance().showArray(a, delay, j);
            }
            amountOfCompare ++;
            a[j] = element; // insert element
            //SortingAnimation.instance().showArray(a, delay);
        } // a[0]...a[j] sorted
        long end = System.nanoTime();
        long time = TimeUnit.NANOSECONDS.toMillis(end - start);
        SortingAnimation.instance().showArray(a, delay);
        LOG.info("Insertion Sort used {} comparinsons and it took {} ms with a delay of {} ms between Comparisons",
                amountOfCompare, time, delay);
        return a;
    }

    public static int [] insertionSort2(final int[] array){
        long start = System.nanoTime();
        int delay = 10;
        int[] a = growArrayWithLeadingSlot(array);
        int amountOfCompare = 0;
        int element;
        int j;
        for (int i = 1; i < a.length; i++) {
            element = a[i]; // store next element for insert
            a[0] = element; // dummy-element
            j = i; // a[0]..a[j-1] already sorted
            while ((a[j - 1] > element)) {
                amountOfCompare++;
                a[j] = a[j - 1]; // shift right
                j--; // go further left
                SortingAnimation.instance().showArray(a, delay, j);
            }
            amountOfCompare++;
            a[j] = element; // insert element
        } // a[0]...a[j] sorted

        int[] a_normalized = shrinkArrayByRemovingFirst(a);
        long end = System.nanoTime();
        long time = TimeUnit.NANOSECONDS.toMillis(end - start);
        SortingAnimation.instance().showArray(a_normalized, delay);
        LOG.info("Insertion Sort Optimized used {} comparisons and it took {} ms with a delay of {} ms between Comparisons",
                amountOfCompare, time, delay);
        return a_normalized;
    }

    public static int[] selectionSort(int[] a){
        long start = System.nanoTime();
        int delay = 10;
        int amountOfCompare = 0;
        for (int i = 0; i < a.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++){
                amountOfCompare++;
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
                SortingAnimation.instance().showArray(a, delay, j);
            }
            amountOfCompare++;
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
        }
        SortingAnimation.instance().showArray(a, delay);
        long end = System.nanoTime();
        long time = TimeUnit.NANOSECONDS.toMillis(end - start);
        LOG.info("Selection Sort used {} comparisons and it took {} ms with a delay of {} ms between Comparisons",
                amountOfCompare, time, delay);
        return a;
    }

    public static int[] bubbleSort(int[] a){
        long start = System.nanoTime();
        int delay = 10;
        int amountOfCompare = 0;
        boolean swapped;
        for (int i = 0; i < a.length; i++){
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++){
                amountOfCompare++;
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                    SortingAnimation.instance().showArray(a, delay);
                }
            }
            if (!swapped) break;
        }
        SortingAnimation.instance().showArray(a, delay);
        long end = System.nanoTime();
        long time = TimeUnit.NANOSECONDS.toMillis(end - start);
        LOG.info("Bubble Sort used {} comparisons and it took {} ms with a delay of {} ms between Comparisons",
                amountOfCompare, time, delay);
        return a;
    }

    public static void shellSort(int[] a){

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
