package sorts;

import java.util.Arrays;

/**
 * <b>Merge Sort</b>
 *
 * * Divide and Conquer.
 *
 * 1. Split array into two halves.
 *
 * 2. Sort each half recursively using merge sort.
 *
 * 3. Merge the two sorted halves to new completely sorted array.
 *
 * Run time analysis:
 *
 * Worst Case: O(n log n)) Average Case: O(n log n) Best Case: O(n log n)
 *
 * @author Joon Hyung Lim
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        System.out.println("Unsorted: ");
        for (int n : array) {
            System.out.print(n + " ");
        }

        System.out.println("");

        sort(array);

        System.out.println("Sorted: ");
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    public static void sort(int[] list) {

        System.out.println("merge sort started.");
        mergeSort(list);
        System.out.println("merge sort complete.");
    }

    /**
     * Merge Sort
     *
     * @param list
     */
    private static void mergeSort(int[] list) {
        if (list.length <= 1) { // list's length is <= 1.
            return;
        }

        int middle = list.length / 2;
        int[] left = Arrays.copyOfRange(list, 0, middle);
        int[] right = Arrays.copyOfRange(list, middle, list.length);

        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);

    }

    private static void merge(int[] list, int[] left,
            int[] right) {

        int i = 0;
        int j = 0;
        int y = 0;
        while (i < left.length && j < right.length) { // until either left or right is completely used up
            if (left[i] < right[j]) {
                list[y] = left[i];
                i++;
            } else {
                list[y] = right[j];
                j++;
            }
            y++;
        }

        copy(left, i, list, y, left.length - i); // if any elements remaining in left array, put rest into list
        copy(right, j, list, y, right.length - j); // if any elements remaining in right array, put rest into list

    }

    private static void copy(int[] src, int srcStart,
            int[] tgt, int tgtStart, int length) {

        for (int x = 0; x < length; x++) {
            tgt[x + tgtStart] = src[x + srcStart];
        }
    }

}
