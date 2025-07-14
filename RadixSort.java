/**
 * This class implements the Radix Sort algorithm using Counting Sort
 * as a stable subroutine for digit-level sorting.
 *
 * Radix Sort is a non-comparison-based sorting algorithm ideal for
 * sorting integers (positive only in this version).
 *
 * Time Complexity:
 * - Best Case: O(nk)
 * - Average Case: O(nk)
 * - Worst Case: O(nk)
 *     where n = number of elements, k = number of digits in the max number
 *
 * Space Complexity: O(n + k)
 * Stable: Yes
 *
 * Limitation: Only works for non-negative integers in this implementation.
 */

public class RadixSort {

    /**
     * Main method to perform Radix Sort on the array.
     *
     * @param arr the array to sort
     */
    public static void radixSort(int[] arr) {
        // Step 1: Find the maximum number to know number of digits
        int max = getMax(arr);

        // Step 2: Do counting sort for every digit place (1s, 10s, 100s...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    /**
     * A utility method to return the maximum value in the array.
     *
     * @param arr the input array
     * @return the maximum integer in the array
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * A stable Counting Sort used by Radix Sort to sort based on digit at exp place.
     *
     * @param arr the input array
     * @param exp the digit place (1 for units, 10 for tens, etc.)
     */
    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];      // output array
        int[] count = new int[10];      // digit range [0–9]

        // Count the occurrences of each digit at current place
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (stable sort: traverse from right to left)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted values back into original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * Utility method to print the array.
     *
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Sample usage
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original array:");
        printArray(arr);

        radixSort(arr);

        System.out.println("Sorted array using Radix Sort:");
        printArray(arr);
    }
}
