package ch.hslu.ad.A2_EX_Sortieren2;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in zufälliger Reihenfolge.
     *
     * @param size die Anzahl der Zahlen
     *
     */
    static int[] getShuffledNumbers(int size) {
        List<Integer> numbers = IntStream.range(1, size + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in aufsteigender Reihenfolge.
     *
     * @param size die Anzahl der Zahlen
     */
    static int[] getAscendingNumbers(int size) {
        return IntStream.range(1, size + 1).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in absteigender Reihenfolge.
     *
     * @param size die Anzahl der Zahlen
     */
    static int[] getDescendingNumbers(int size) {
        return IntStream.range(1, size + 1).map(i -> size - i + 1).toArray();
    }

    static int[] heapSort(FixedSizeHeap fixedSizeHeap){
        int n = fixedSizeHeap.size();
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--){
            sorted[i] = fixedSizeHeap.extractMax();
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] numbers = getShuffledNumbers(50);
        //SortingLibrary.quickSort(numbers, true);

        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap(50);
        for (int number : numbers){
            fixedSizeHeap.add(number);
            System.out.println(fixedSizeHeap);
        }
        int[] sorted = heapSort(fixedSizeHeap);
        System.out.println(Arrays.toString(sorted));
    }



}
