package sorts;

public class CountingSort {
// only for numbers between 0 and the length of the array.

    public static void sort(int[] originalArray) {

        if (originalArray.length <= 1) { // array's length is <= 1.
            System.out.println("array is too small to sort.");
            return;
        }

        System.out.println("counting sort started.");

        int[] incrementArray = new int[originalArray.length];

        //increment the indices representing each integer stored in the originalArray
        for (int i = 0; i < originalArray.length; i++) {
            incrementArray[originalArray[i]]++;
        }

        int i = incrementArray.length - 1;
        int p = i;

        while (i >= 0) {
            while (incrementArray[i] > 0) {
                originalArray[p] = i;
                incrementArray[i]--;
                p--;
            }
            i--;
        }

        System.out.println("counting sort complete.");

    }

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
}
