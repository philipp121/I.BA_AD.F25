package ch.hslu.ad.A2_EX_Sortieren2;

import ch.hslu.ad.A1_EX_Sortieren1.animation.SortingAnimation;

public class SortingLibrary {

    public static double quickSort(int[] a){
        double start = System.nanoTime();
        quickSort(a, 0, a.length -1);
        double end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    public static void quickSort(int[] a, boolean animated){
        if (animated){
            quickSortAnimated(a, 0, a.length -1);
        } else {
            quickSort(a, 0, a.length -1);
        }
    }

    private static void quickSort(int[] a, int start, int end){
        if (start < end){
            int p = partition(a, start, end);
            quickSort(a, start, p);
            quickSort(a, p + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end){
        int pivot = a[start];
        int i = start - 1;
        int j = end + 1;

        while (true){
            do {
                i++;
            } while (a[i] < pivot);

            do {
                j--;
            } while (a[j] > pivot);

            if (i >= j)  {
                return j;
            }
                swap(a, i, j);
            }
    }

    private static void quickSortAnimated(int[] a, int start, int end){
        if (start < end){
            int p = partitionAnimated(a, start, end);
            quickSortAnimated(a, start, p);
            quickSortAnimated(a, p + 1, end);
        }
    }

    private static int partitionAnimated(int[] a, int start, int end){
        int delay = 100;
        int pivot = a[start];
        int i = start - 1;
        int j = end + 1;

        while (true){
            do {
                i++;
                SortingAnimation.instance().showArray(a, delay, i);
            } while (a[i] < pivot);

            do {
                j--;
                SortingAnimation.instance().showArray(a, delay, j);
            } while (a[j] > pivot);

            if (i >= j)  {
                SortingAnimation.instance().showArray(a, delay);
                return j;
            }
            swap(a, i, j);
            SortingAnimation.instance().showArray(a, delay);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
