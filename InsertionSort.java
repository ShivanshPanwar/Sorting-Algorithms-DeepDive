/**
 * InsertionSort.java
 *
 * This class implements the Insertion Sort algorithm.
 * It builds the sorted array one element at a time by placing
 * each new element into its correct position relative to already-sorted elements.
 *
 * Time Complexity:
 * - Best Case: O(n)        [Already sorted]
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2)     [Reverse sorted]
 *
 * Space Complexity: O(1)   [In-place]
 * Stable: Yes
 */

public class InsertionSort {

    /**
     * Sorts an integer array in ascending order using Insertion Sort.
     *
     * @param arr the array to sort
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            // Shift larger elements one position ahead
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the current element in its correct position
            arr[j + 1] = current;
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
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
