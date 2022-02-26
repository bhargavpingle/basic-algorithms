package sort;

public class InsertionSort {

    /**
     * Enhanced Insertion Sort with optional verbose logging.
     * Shows number of comparisons and shifts, and array state if verbose is enabled.
     *
     * @param arr     the array to be sorted
     * @param verbose true to print array state after each step
     */
    public static void sort(int[] arr, boolean verbose) {
        if (arr == null || arr.length <= 1) {
            System.out.println("No sorting needed (null or single-element array).");
            return;
        }

        int comparisons = 0;
        int shifts = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements to the right to make room for key
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }

            if (j >= 0) comparisons++;  // Last failed comparison

            arr[j + 1] = key;
            shifts++;

            if (verbose) {
                System.out.printf("After inserting element at index %d (%d): ", i, key);
                printArray(arr);
            }
        }

        System.out.printf("Insertion Sort completed with %d comparison(s) and %d shift(s).\n", comparisons, shifts);
    }

    /**
     * Overloaded method for default usage (no verbose output).
     */
    public static void sort(int[] arr) {
        sort(arr, false);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

