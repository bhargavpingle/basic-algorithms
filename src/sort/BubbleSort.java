package sort;

public class BubbleSort {

    /**
     * Enhanced Bubble Sort implementation with pass and swap counters.
     * Also supports verbose mode to show array state per pass.
     *
     * @param arr    the array to be sorted
     * @param verbose if true, prints array after each pass
     */
    public static void sort(int[] arr, boolean verbose) {
        if (arr == null || arr.length <= 1) {
            System.out.println("No sorting needed (null or single-element array).");
            return;
        }

        int n = arr.length;
        int totalSwaps = 0;
        int pass = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            pass++;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    totalSwaps++;
                }
            }

            if (verbose) {
                System.out.printf("Pass %d: ", pass);
                printArray(arr);
            }

            // If no elements were swapped in a full pass, the array is sorted
            if (!swapped) break;
        }

        System.out.printf("Bubble Sort completed in %d pass(es) with %d swap(s).\n", pass, totalSwaps);
    }

    /**
     * Overloaded method with verbose=false by default.
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
