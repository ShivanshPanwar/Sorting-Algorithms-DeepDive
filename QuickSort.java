import java.util.Random;
// The Random class provides methods to generate pseudo-random numbers of different types
/**
 * QuickSort.java
 *
 * Implements Quick Sort with different pivot strategies:
 * 1. Last Element as Pivot
 * 2. First Element as Pivot
 * 3. Random Element as Pivot
 * 4. Middle Element as Pivot
 *
 * Time Complexity:
 * - Best/Average Case: O(n log n)
 * - Worst Case: O(n^2) [on already sorted or reverse-sorted data without randomized pivot]
 *
 * Space Complexity: O(log n) (in-place, recursive stack)
 * Stable: No
 */

public class QuickSort {

    // ✅ Utility method to swap elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // --------------------------------------------------------------------------------
    // 1. Quick Sort using Last Element as Pivot
    // --------------------------------------------------------------------------------
    public static void quickSortLastPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionLast(arr, low, high);
            quickSortLastPivot(arr, low, pivotIndex - 1);
            quickSortLastPivot(arr, pivotIndex + 1, high);
        }
    }

    public static int partitionLast(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // --------------------------------------------------------------------------------
    // 2. Quick Sort using First Element as Pivot
    // --------------------------------------------------------------------------------
    public static void quickSortFirstPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionFirst(arr, low, high);
            quickSortFirstPivot(arr, low, pivotIndex - 1);
            quickSortFirstPivot(arr, pivotIndex + 1, high);
        }
    }

    public static int partitionFirst(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = high;

        for (int j = high; j > low; j--) {
            if (arr[j] > pivot) {
                swap(arr, i, j);
                i--;
            }
        }

        swap(arr, i, low);
        return i;
    }

    // --------------------------------------------------------------------------------
    // 3. Quick Sort using Random Element as Pivot
    // --------------------------------------------------------------------------------
    public static void quickSortRandomPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandom(arr, low, high);
            quickSortRandomPivot(arr, low, pivotIndex - 1);
            quickSortRandomPivot(arr, pivotIndex + 1, high);
        }
    }

    public static int partitionRandom(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomPivot = low + rand.nextInt(high - low + 1);
        swap(arr, randomPivot, high); // Move random pivot to end
        return partitionLast(arr, low, high); // Use last pivot logic
    }

    // --------------------------------------------------------------------------------
    // 4. Quick Sort using Middle Element as Pivot
    // --------------------------------------------------------------------------------
    public static void quickSortMidPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionMid(arr, low, high);
            quickSortMidPivot(arr, low, pivotIndex - 1);
            quickSortMidPivot(arr, pivotIndex + 1, high);
        }
    }

    public static int partitionMid(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(arr, mid, high); // Move mid to end
        return partitionLast(arr, low, high); // Reuse last-pivot logic
    }

    // --------------------------------------------------------------------------------
    // Utility Method to Print the Array
    // --------------------------------------------------------------------------------
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // --------------------------------------------------------------------------------
    // Main Method to Demonstrate All Pivot Strategies
    // --------------------------------------------------------------------------------
    public static void main(String[] args) {
        int[] original = {10, 7, 8, 9, 1, 5};

        System.out.println("Original Array:");
        printArray(original);

        // Using Last Element as Pivot
        int[] arr1 = original.clone();
        quickSortLastPivot(arr1, 0, arr1.length - 1);
        System.out.println("\nSorted using Last Element as Pivot:");
        printArray(arr1);

        // Using First Element as Pivot
        int[] arr2 = original.clone();
        quickSortFirstPivot(arr2, 0, arr2.length - 1);
        System.out.println("\nSorted using First Element as Pivot:");
        printArray(arr2);

        // Using Random Element as Pivot
        int[] arr3 = original.clone();
        quickSortRandomPivot(arr3, 0, arr3.length - 1);
        System.out.println("\nSorted using Random Element as Pivot:");
        printArray(arr3);

        // Using Middle Element as Pivot
        int[] arr4 = original.clone();
        quickSortMidPivot(arr4, 0, arr4.length - 1);
        System.out.println("\nSorted using Middle Element as Pivot:");
        printArray(arr4);
    }
}
