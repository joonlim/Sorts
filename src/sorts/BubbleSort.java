package sorts;

/**
 * <b>Bubble Sort</b>
 *
 * * Algorithm works in place.
 *
 * Compare each pair of adjacent elements from the beginning of the array and if
 * they are in reversed order, swap them. If at least one swap has been done,
 * repeat.
 *
 * Run time analysis:
 *
 * Worst Case: O(n^2) Average Case: O(n^2) Best Case: O(n)
 *
 * @author Joon Hyung Lim
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        // bubblesort 1
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

        //bubblesort 2
        array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        System.out.println("\nUnsorted: ");
        for (int n : array) {
            System.out.print(n + " ");
        }

        System.out.println("");

        sort2(array);

        System.out.println("Sorted: ");
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * Sorts int array using a bubble sort.
     *
     * @param array
     */
    public static void sort(int[] array) { // sort int array.

        if (array.length <= 1) { // array's length is <= 1.
            System.out.println("array is too small to sort.");
            return;
        }

        System.out.println("bubble sort 1 started.");

        boolean swapped = true;

        for (int i = 0; i <= array.length - 2 && swapped; i++) {
            swapped = false; // initialize swapped to false at the start of the
            // loop.
            // from index up to the second last index. Until swapped is still
            // false.
            for (int j = array.length - 1; j > i; j--) { // from the last index
                // until
                // index after i.
                if (array[j] < array[j - 1]) { // compare this element with
                    // previous element.
                    swap(array, j, j - 1);
                    swapped = true;
                }
            } // close first for loop.
        } // close second for loop.

        System.out.println("bubble sort 1 complete.");
    }

    /**
     * Experimental bubble sort. Sorts int array using a bubble sort without
     * using a boolean swapped value.
     *
     * @param array
     */
    public static void sort2(int[] array) { // sort int array without using a
        // swapped boolean value.

        if (array.length <= 1) { // array's length is <= 1.
            System.out.println("array is too small to sort.");
            return;
        }

        System.out.println("bubble sort 2 started.");

        for (int i = 0; i <= array.length - 2; i++) {
            // from index up to the second last index.
            for (int j = array.length - 1; j > i; j--) { // from the last index
                // until
                // index after i.
                if (array[j] < array[j - 1]) { // compare this element with
                    // previous element.
                    swap(array, j, j - 1);
                }
            } // close first for loop.
        } // close second for loop.

        System.out.println("bubble sort 2 complete.");
    }

    /**
     * @param array
     * @param index1
     * @param index2
     */
    public static void swap(int[] array, int index1, int index2) { // swap int

        // array.
        try {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("out of bounds index");
        }
    }

}
