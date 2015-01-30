package sorts;

/**
 * <b>Selection Sort</b>
 *
 * * Algorithm works in place.
 *
 * Array is divided into two parts - sorted and unsorted. At the beginning, the
 * sorted part is empty. At every step, the algorithm finds the minimum element
 * in the unsorted part and swaps it with the element at the front of the
 * unsorted part. Then the element joins the sorted part. When the unsorted part
 * becomes empty, the algorithm stops.
 *
 * Run time analysis:
 *
 * Worst Case: O(n^2) Average Case: O(n^2) Best Case: O(n^2)
 *
 * @author Joon Hyung Lim
 *
 */
public class SelectionSort {

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

    /**
     * Sorts int array using a selection sort.
     *
     * @param array
     */
    public static void sort(int[] array) { // sort int array

        if (array.length <= 1) { // array's length is <= 1.
            System.out.println("array is too small to sort.");
            return;
        }

        System.out.println("selection sort started.");

        int min;

        for (int i = 0; i <= array.length - 2; i++) { // from index 0 up to second to
            // last index. Goes through
            // unsorted part.
            min = i;

            for (int j = i + 1; j <= array.length - 1; j++) { // from index i+1 to
                // last index
                if (array[j] < array[min]) // find the next minimum value.
                {
                    min = j;
                }

            } // close second loop. next min is found.

            swap(array, min, i); // place the next min in the beginning of the
            // unsorted array(end of the new sorted
            // array.)

        } // close first loop.

        System.out.println("selection sort complete.");
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
