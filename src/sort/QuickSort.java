package sort;

public class QuickSort {

    private static int comparisons = 0;
    private static int swaps = 0;

    /**
     * Enhanced Quick Sort with verbose output, swap/comparison counters, and null safety.
     *
     * @param arr     the array to sort
     * @param verbose true to print array state at each partition step
     */
    public static void sort(int[] arr, boolean verbose) {
        if (arr == null || arr.length <= 1) {
            System.out.println("No sorting needed (null or single-element array).");
            return;
        }

        comparisons = 0;
        swaps = 0;

        quickSort(arr, 0, arr.length - 1, verbose);

        System.out.printf("Quick Sort completed with %d comparison(s) and %d swap(s).\n", comparisons, swaps);
    }

    /**
     * Default non-verbose usage.
     */
    public static void sort(int[] arr) {
        sort(arr, false);
    }

    private static void quickSort(int[] arr, int low, int high, boolean verbose) {
        if (low < high) {
            int pi = partition(arr, low, high, verbose);

            quickSort(arr, low, pi - 1, verbose);
            quickSort(arr, pi + 1, high, verbose);
        }
    }

    private static int partition(int[] arr, int low, int high, boolean verbose) {
        int pivot = arr[high];
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        if (verbose) {
            System.out.printf("Partition [%d-%d] | Pivot: %d → ", low, high, pivot);
            printArray(arr, low, high);
        }

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swaps++;
        }
    }

    private static void printArray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("]");
    }
}
