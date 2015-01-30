/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Joon
 */
public class SortingSpeeds {

    final static int NUMBEROFELEMENTS = 1_000_000;

    public static void main(String[] args) throws Exception {

        int choice;
        int[] array;
        double startTime;
        double endTime;
        double duration;

        Scanner input = new Scanner(System.in);

        while (true) {

            printMenu();

            array = new int[NUMBEROFELEMENTS];
            randomizeArray(array);

            String choicechar = input.next();

            if (choicechar.equals("q")) {
                System.out.println("goodbye!");
                break;
            }
            
            choice = Integer.parseInt(choicechar);

            System.out.println(""); // new line

            startTime = System.nanoTime();

            switch (choice) {
                case 1:
                    BubbleSort.sort(array);
                    break;
                case 2:
                    BubbleSort.sort2(array);
                    break;
                case 3:
                    CountingSort.sort(array);
                    break;
                case 4:
                    HeapSort.sort(array);
                    break;
                case 5:
                    InsertionSort.sort(array);
                    break;
                case 6:
                    MergeSort.sort(array);
                    break;
                case 7:
                    QuickSort.sort(array);
                    break;
                case 8:
                    SelectionSort.sort(array);
                    break;
                case 9:
                    Arrays.sort(array);
                default:
                    break;
            }

            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println(""); // new line
            System.out.println("sorted " + NUMBEROFELEMENTS + " integers.");
            System.out.println("duration: " + duration / 1_000_000_000 + " seconds");
            System.out.println(""); // new line
        }

    }
//
//    private static void randomizeArray(int[] array) {
//        for (int i = 0; i < NUMBEROFELEMENTS; i++) {
//            array[i] = (int) (Math.random() * NUMBEROFELEMENTS);
//        }
//    }

    // quick sort test
    private static void randomizeArray(int[] array) {
        for (int i = 0; i < NUMBEROFELEMENTS; i++) {
            array[i] = (int) (Math.random() * NUMBEROFELEMENTS);
        }
    }

    private static void printMenu() {

        System.out.println("1) Bubble Sort 1");
        System.out.println("2) Bubble Sort 2");
        System.out.println("3) Counting Sort");
        System.out.println("4) Heap Sort");
        System.out.println("5) Insertion Sort");
        System.out.println("6) Merge Sort");
        System.out.println("7) Quick Sort");
        System.out.println("8) Selection Sort");
        System.out.println("9) Arrays.sort");
        System.out.print("Which sort would you like to test? ");
    }
}
