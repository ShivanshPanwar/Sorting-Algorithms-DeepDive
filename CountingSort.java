/**
 * CountingSort.java
 *
 * This class implements the Counting Sort algorithm.
 * It's efficient for sorting non-negative integers where the maximum value (k) is not significantly greater than the array length (n).
 *
 * Time Complexity:
 * - Best, Average, Worst Case: O(n + k) where k is the maximum element value
 *
 * Space Complexity: O(n + k)
 * Stable: Yes (this version preserves the order of equal elements)
 * Limitation: Only works with non-negative integers (extendable to negatives with adjustments)
 */

public class CountingSort {

    /**
     * Sorts a non-negative integer array using Counting Sort.
     *
     * @param inputArr the array to be sorted
     */
    public static void countSort(int[] inputArr) {
        int n = inputArr.length;

        if (n == 0) return;

        // Step 1: Find the maximum element
        int max = inputArr[0];
        for (int x : inputArr) {
            max = Math.max(max, x);
        }

        // Step 2: Create and fill the count array (frequency of each element)
        int[] countArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            countArr[inputArr[i]]++;
        }

        // Step 3: Convert count array to prefix sum (cumulative count)
        for (int i = 1; i <= max; i++) {
            countArr[i] += countArr[i - 1];
        }

        // Step 4: Build the output array using the count array
        int[] outputArr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int val = inputArr[i];
            outputArr[countArr[val] - 1] = val;
            countArr[val]--;  // Decrease count for duplicate handling
        }

        // Step 5: Copy sorted output back into the original input array
        for (int i = 0; i < n; i++) {
            inputArr[i] = outputArr[i];
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
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original array:");
        printArray(arr);

        countSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
