package sort;

public class SelectionSort {

    /**
     * Enhanced Selection Sort with comparison/swap count and optional verbose output.
     *
     * @param arr     the array to sort
     * @param verbose if true, prints array state after each outer iteration
     */
    public static void sort(int[] arr, boolean verbose) {
        if (arr == null || arr.length <= 1) {
            System.out.println("No sorting needed (null or single-element array).");
            return;
        }

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swap(arr, i, minIdx);
                swaps++;
            }

            if (verbose) {
                System.out.printf("Step %d: ", i + 1);
                printArray(arr);
            }
        }

        System.out.printf("Selection Sort completed with %d comparison(s) and %d swap(s).\n", comparisons, swaps);
    }

    /**
     * Overloaded method for default usage (non-verbose).
     */
    public static void sort(int[] arr) {
        sort(arr, false);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
