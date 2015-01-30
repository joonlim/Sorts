package sorts;

/**
 * <b>Quick Sort</b>
 *
 * * Algorithm works in place.
 *
 * * Divide and Conquer.
 *
 * 1. Choose a pivot value. We take the value of the first element as pivot
 * value.
 *
 * 2. Partition. Rearrange elements in such a way, that all elements which are
 * lesser than the pivot go to the left part of the array and all elements
 * greater than the pivot go to the right part of the array. Values equal to
 * the pivot can stay in any part of the array. Here we let values equal to the
 * pivot join values greater than the pivot on the right side. Notice that the
 * array may be divided in non-equal parts.
 *
 * 3. Sort both parts by applying the quicksort algorithm recursively to the
 * left and the right parts.
 *
 * Run time analysis:
 *
 * Worst Case: O(n^2) Average Case: O(n log n) Best Case: O(n log n)
 *
 * @author Joon Hyung Lim
 *
 */
public class QuickSort {

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
     * Sorts int array using a quick sort.
     *
     * @param array
     */
    public static void sort(int[] array) { // sort int array.

        if (array.length <= 1) { // array's length is <= 1.
            System.out.println("array is too small to sort.");
            return;
        }
        
        System.out.println("quick sort started.");
        sort(array, 0, array.length - 1);
        System.out.println("quick sort complete.");
    }

    /**
     * @param array
     * @param lo
     * @param hi
     */
    private static void sort(int[] array, int lo, int hi) { // recursive call

        if ((hi - lo) < 0) // fewer than 2 items.
        {
            return;
        }

        int splitPoint = split(array, lo, hi);
        sort(array, lo, splitPoint - 1); // left subarray recursion
        sort(array, splitPoint + 1, hi); // right subarray recursion
    }

    /**
     * @param array
     * @param lo
     * @param hi
     * @return index of split point of array
     */
    private static int split(int[] array, int lo, int hi) {

        int left = lo + 1;
        int right = hi;

        int pivot = array[lo];

        while (true) {
            while (left <= right) {
                if (array[left] < pivot) {
                    left++;
                } else {
                    break;
                }
            }

            while (right > left) {
                if (array[right] < pivot) {
                    break;
                } else {
                    right--;
                }
            }

            if (left >= right) {
                break;
            }

            swap(array, left, right);

            // advance each one step.
            left++;
            right--;
        }

        // swap pivot with left-1 position.
        array[lo] = array[left - 1];
        array[left - 1] = pivot;

        // return the split point.
        return left - 1;
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
