/**
 * BubbleSort.java
 * 
 * This class contains the implementation of the Bubble Sort algorithm.
 * It also includes an optimization using a flag to terminate early
 * if the array becomes sorted before all passes are completed.
 *
 * Time Complexity:
 * - Best Case: O(n) [Already sorted]
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2)
 *
 * Space Complexity: O(1) [In-place sorting]
 * Stable: Yes
 */

public class BubbleSort {

    /**
     * Sorts an integer array in ascending order using Bubble Sort.
     *
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Perform pairwise comparisons
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped in inner loop, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Utility method to print an array.
     *
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Sample usage
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
