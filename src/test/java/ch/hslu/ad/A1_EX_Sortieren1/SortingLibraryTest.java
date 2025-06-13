package ch.hslu.ad.A1_EX_Sortieren1;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SortingLibraryTest {

    private boolean arraysMatchList(int[] array, List<Integer> list) {
        if (array.length != list.size()) return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != list.get(i)) return false;
        }
        return true;
    }

    @Test
    void insertionSortWithMixed(){
        List<Integer> numbers = IntStream.range(1, 50 + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        int[] numbersShuffled = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.insertionSort(numbersShuffled);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void insertionSortWithAscending(){
        List<Integer> numbers = IntStream.range(1, 50 + 1).boxed().collect(Collectors.toList());
        int[] numbersAscending = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.insertionSort(numbersAscending);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void insertionSortWithDescending(){
        List<Integer> numbers = IntStream.range(1, 50 + 1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int[] numbersAscending = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.insertionSort(numbersAscending);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void selectionSortWithMixed(){
        List<Integer> numbers = IntStream.range(1, 50 + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        int[] numbersShuffled = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.selectionSort(numbersShuffled);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void selectionSortWithAscending(){
        List<Integer> numbers = IntStream.range(1, 50 + 1).boxed().collect(Collectors.toList());
        int[] numbersAscending = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.selectionSort(numbersAscending);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void selectionSortWithDescending(){
        List<Integer> numbers = IntStream.range(1, 50 + 1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int[] numbersAscending = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.selectionSort(numbersAscending);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void bubbleSortWithMixed(){
        List<Integer> numbers = IntStream.range(1, 50 + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        int[] numbersShuffled = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.bubbleSort(numbersShuffled);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void bubbleSortWithAscending(){
        List<Integer> numbers = IntStream.range(1, 50 + 1).boxed().collect(Collectors.toList());
        int[] numbersAscending = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.bubbleSort(numbersAscending);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

    @Test
    void bubbleSortWithDescending(){
        List<Integer> numbers = IntStream.range(1, 50 + 1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int[] numbersAscending = numbers.stream().mapToInt(Integer::intValue).toArray();
        int[] numbersSorted = SortingLibrary.bubbleSort(numbersAscending);
        Collections.sort(numbers);
        assertTrue(arraysMatchList(numbersSorted, numbers));
    }

}