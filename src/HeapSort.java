/*
 * Name: Ariane Yu
 * PID:  A16008867
 */


import java.util.Arrays;

/**
 * Using a binary min-heap to sort arrays.
 */
public class HeapSort {

    /**
     * This method would sort the given array using the d-heap.
     *
     * @param arr The array that would be sorted.
     * @param start the start of the sorting.
     * @param end the end of the sorting.
     */
    public static void heapSort(int[] arr, int start, int end) {
        int d = 2;
        int size = 6;
        int[] sorted = new int[arr.length];
        dHeap<Integer> intHeap = new dHeap<>(d, size, false);
        for (int i = start; i <= end; i++) {
            intHeap.add(arr[i]);
        }
        for (int j = start; j <= end; j++) {
            arr[j] =intHeap.remove();
        }
    }

}
