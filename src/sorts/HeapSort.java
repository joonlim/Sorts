package sorts;

/**
 * <b>Heap Sort</b>
 *
 * * Algorithm works in place.
 *
 * Convert the array into a max heap. O(log n)
 *
 * Sort the heap by continously swapping the root(max) with the last element in
 * the heap, setting the heap boundaries to not include the swapped root, and
 * reheapifying the remaining heap until the heap is empty.
 *
 * Run time analysis:
 *
 * Worst Case: O(n log n) Average Case: O(n log n) Best Case: O(n log n)
 *
 * @author Joon Hyung Lim
 *
 */
public class HeapSort {

    public static void main(String[] args) throws Exception {
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

    public static void makeHeap(int[] data, int size) throws Exception {

        int i;
        int childPosition;
        int position;

        for (i = parentPosition(size - 1); i >= 0; i--) {
            position = i;
            while (leftChildPosition(position) < size) {

                childPosition = leftChildPosition(position);

                if (childPosition < size - 1 // right child exists
                        && data[childPosition + 1] > data[childPosition]) // right
                // child
                // is
                // greater
                // in
                // value
                {
                    childPosition++;
                }
                if (data[childPosition] > data[position]) {
                    swap(data, childPosition, position);
                    position = childPosition;
                } else {
                    break;
                }

            }
        }
    }

    public static int parentPosition(int position) {

        return (position - 1) / 2;
    }

    public static int leftChildPosition(int position) {

        return 2 * position + 1;
    }

    public static int rightChildPosition(int position) {

        return 2 * position + 2;
    }

    public static void swap(int[] data, int index1, int index2)
            throws Exception {

        if (data.length == 0) {
            throw new Exception();
        }
        if (index1 < 0 || index2 < 0) {
            throw new Exception();
        }
        if (index1 >= data.length || index2 >= data.length) {
            throw new Exception();
        }

        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }

    /**
     * Trickle down the element at the root. While the element has a value lower
     * than one of its children, swap it with the higher valued child.
     *
     * @precondition The last element was moved to the root prior to the start
     * of the method.
     *
     * @param data
     * @param heapSize
     */
    public static void fixHeap(int[] data, int heapSize) throws Exception {

        int position = 0;
        int childPosition;
        // while at least the left child exists
        while (leftChildPosition(position) < heapSize) {
            childPosition = leftChildPosition(position);

            if (childPosition < heapSize - 1 // check if right child exists
                    && data[childPosition + 1] > data[childPosition]) // right
            // child
            // is
            // greater
            // than
            // left
            // child
            {
                childPosition++;
            }
            if (data[position] < data[childPosition]) {
                swap(data, position, childPosition);
                position = childPosition;
            } else {
                return;
            }
        }
    }

    public static void sort(int[] data) throws Exception {
        System.out.println("heap sort started.");
        sort(data, data.length);
        System.out.println("heap sort complete.");
    }

    public static void sort(int[] data, int size) throws Exception {

        int lastHeapPosition;
        makeHeap(data, size);
        lastHeapPosition = size - 1;
        while (lastHeapPosition > 0) {
            swap(data, 0, lastHeapPosition);
            fixHeap(data, lastHeapPosition);
            lastHeapPosition--;
        }
    }
}
