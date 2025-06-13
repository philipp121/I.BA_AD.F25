package ch.hslu.ad.A1_EX_Sortieren1;

import ch.hslu.ad.A1_EX_Sortieren1.animation.SortingAnimation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingMain {

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

    public static void main(String[] args) {
        // Beispiel: Zahlen von 1 bis 50 in zufälliger Reihenfolge
        int[] numbers = getShuffledNumbers(50);
        //SortingLibrary.insertionSort(numbers);
        //SortingLibrary.selectionSort(numbers);
        SortingLibrary.bubbleSort(numbers);
    }
}
