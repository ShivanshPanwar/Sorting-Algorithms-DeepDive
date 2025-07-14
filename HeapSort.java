/**
 * HeapSort.java
 *
 * This class implements the Heap Sort algorithm using a max-heap.
 * The array is first converted into a max-heap, then the largest element (root)
 * is repeatedly moved to the end of the array and heapified again.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n)
 *
 * Space Complexity: O(1) [in-place]
 * Stable: No (because it moves elements far apart)
 */

public class HeapSort {

    /**
     * Main method to perform heap sort on an array.
     *
     * @param arr the array to be sorted
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted at index i, where n is the heap size.
     *
     * @param arr the array representing the heap
     * @param n the current size of the heap
     * @param i the index to heapify
     */
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;        // Initialize largest as root
        int left = 2 * i + 1;   // Left child
        int right = 2 * i + 2;  // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param arr the array
     * @param i index of first element
     * @param j index of second element
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array using Heap Sort:");
        printArray(arr);
    }
}
