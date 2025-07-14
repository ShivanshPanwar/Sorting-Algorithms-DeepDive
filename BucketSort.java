/**
 *
 * This class implements the Bucket Sort algorithm.
 * It distributes elements into buckets, sorts each bucket individually
 * (using insertion sort), and then concatenates the buckets.
 *
 * Recommended for sorting floating-point numbers in [0, 1).
 *
 * Time Complexity:
 * - Best Case: O(n + k)
 * - Average Case: O(n + k)
 * - Worst Case: O(n^2) [if all elements go to one bucket]
 *
 * Space Complexity: O(n + k)
 * Stable: Depends on the bucket sorting method (here it is stable).
 */

import java.util.*;

public class BucketSort {

    /**
     * Performs bucket sort on a float array in range [0, 1).
     *
     * @param arr the array to sort
     */
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // Step 1: Create n empty buckets (as ArrayLists)
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2: Distribute input array values into buckets
        for (float value : arr) {
            int bucketIndex = (int) (value * n);  // index = value * size
            buckets[bucketIndex].add(value);
        }

        // Step 3: Sort individual buckets using insertion sort
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);  // using Java's built-in sort (can replace with insertion sort)
        }

        // Step 4: Concatenate all buckets into original array
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float value : bucket) {
                arr[index++] = value;
            }
        }
    }

    /**
     * Utility method to print float array.
     *
     * @param arr the array to print
     */
    public static void printArray(float[] arr) {
        for (float val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Sample usage
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.123f, 0.665f, 0.343f};

        System.out.println("Original array:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("Sorted array using Bucket Sort:");
        printArray(arr);
    }
}
