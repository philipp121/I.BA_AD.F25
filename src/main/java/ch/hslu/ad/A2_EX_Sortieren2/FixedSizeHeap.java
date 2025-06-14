package ch.hslu.ad.A2_EX_Sortieren2;

import java.util.Arrays;

public class FixedSizeHeap implements IntegerHeap{

    private int size;
    private int[] a;

    public FixedSizeHeap(int capacity) {
            a = new int[capacity];
    }

    public FixedSizeHeap(int[] a, int size){
        this.a = a;
        this.size = size;
    }

    @Override
    public void add(int number) {
        if (size >= a.length) {
            throw new IllegalStateException("Heap is full.");
        }

        // An nächster freier Stelle einfügen
        a[size] = number;
        int i = size;
        size++;

        // Heapify-Up
        heapifyUp(i);
    }

    @Override
    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int max = a[0];                   // 1. Wurzel merken
        a[0] = a[size - 1];               // 2. Letztes Element nach oben
        size--;                           // 3. Größe verringern
        heapifyDown(0, size - 1);   // 4. Heapify-Down (auf verkleinerten Bereich)
        return max;                       // 5. Max-Wert zurückgeben
    }

    public void heapSort() {
        int n = a.length;

        int li = n / 2;
        int re = n - 1;

        while(li > 0) {
            li = li -1;
            heapifyDown(li, re);
        }

        while (re > 0) {
            swap(re, li);
            re = re - 1;
            heapifyDown(li, re);
        }
    }

    public void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (a[i] > a[parent]) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    public void heapifyDown(int li, int re) {
        int k = 2 * li + 1;
        if (k > re) return;

        // nur ein linkes Kind
        if (k + 1 > re) {
            if (a[k] > a[li]) {
                swap(li, k);
            }
            return;
        }

        // zwei Kinder → größeres auswählen
        if (a[k] < a[k + 1]) {
            k = k + 1;
        }

        if (a[li] < a[k]){
            swap(li, k);
            heapifyDown(k, re); // rekursiv einsinken
        }
    }

    public void swap(int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }
}
