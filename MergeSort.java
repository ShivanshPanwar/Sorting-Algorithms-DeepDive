/**
 * MergeSort.java
 *
 * This class implements the Merge Sort algorithm using a recursive divide-and-conquer approach.
 * It splits the array into two halves, recursively sorts them, and then merges them back.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n)
 *
 * Space Complexity: O(n) [due to temporary arrays used for merging]
 * Stable: Yes
 */

public class MergeSort {

    /**
     * Recursively sorts an array using Merge Sort.
     *
     * @param arr the array to sort
     * @param low the starting index
     * @param high the ending index
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        // Recursively divide and sort both halves
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // Merge the sorted halves
        merge(arr, low, mid, high);
    }

    /**
     * Merges two sorted subarrays of arr[].
     * First subarray is arr[low..mid]
     * Second subarray is arr[mid+1..high]
     *
     * @param arr the original array containing both subarrays
     * @param low starting index of the first subarray
     * @param mid middle index (end of the first subarray)
     * @param high ending index of the second subarray
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++) left[i] = arr[low + i];
        for (int j = 0; j < n2; j++) right[j] = arr[mid + 1 + j];

        // Merge temp arrays back into arr[low..high]
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[]
        while (i < n1) arr[k++] = left[i++];

        // Copy remaining elements of right[]
        while (j < n2) arr[k++] = right[j++];
    }

    /**
     * Utility method to print an array.
     *
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    // Sample usage
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array using Merge Sort:");
        printArray(arr);
    }
}
