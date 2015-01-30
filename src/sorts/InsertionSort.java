package sorts;

/**
 * <b>Insertion Sort</b>
 *
 * * Algorithm works in place.
 *
 * * Inefficient when minimum value is all the way to the right of the
 * array(when trying to sort in non-increasing order) *
 *
 * Array is divided into two parts - sorted and unsorted. At the
 * beginning, the sorted part contains first element of the array and the
 * unsorted part contains the rest. At every step, the algorithm takes first
 * element in the unsorted part and inserts it to the right place of the sorted
 * part. When the unsorted part becomes empty, the algorithm stops.
 *
 * Run time analysis:
 *
 * Worst Case: O(n^2) Average Case: O(n^2) Best Case: O(n)
 *
 * @author Joon Hyung Lim
 *
 */
/**
 * @author Joon
 *
 */
public class InsertionSort {

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
     * Sorts int array using an insertion sort.
     *
     * @param array
     */
    public static void sort(int[] array) { // sort int array

        if (array.length <= 1) { // array's length is <= 1.
            System.out.println("array is too small to sort.");
            return;
        }

        System.out.println("insertion sort started.");

        int cursor;
        int j;

        for (int i = 1; i <= array.length - 1; i++) { // from index 1 up to last
            // index. Goes through unsorted
            // part.

            cursor = array[i]; // set cursor to first element of unsorted array
            j = i; // set j to index of cursor

            while (j > 0 && array[j - 1] > cursor) { // stop when j reaches the
                // first element.
                // Compare cursor with
                // the elements of the
                // sorted array in
                // decreasing order.

                array[j] = array[j - 1]; // move this element in the sorted
                // array right one space.
                j--;

            } // close while loop. All elements in the sorted array that are
            // larger than the cursor are shifted over one space to the
            // right.

            array[j] = cursor; // place cursor in appropriate spot

        } // close for loop.

        System.out.println("insertion sort complete.");
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
