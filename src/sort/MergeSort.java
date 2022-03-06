package sort;

public class MergeSort {

    private static int comparisons = 0;
    private static int merges = 0;

    /**
     * Enhanced Merge Sort with verbose output, merge count, and comparison tracking.
     * @param arr     the array to be sorted
     * @param verbose if true, prints internal merge steps
     */
    public static void sort(int[] arr, boolean verbose) {
        if (arr == null || arr.length <= 1) {
            System.out.println("No sorting needed (null or single-element array).");
            return;
        }

        comparisons = 0;
        merges = 0;

        sortHelper(arr, 0, arr.length - 1, verbose);

        System.out.printf("Merge Sort completed with %d merge(s) and %d comparison(s).\n", merges, comparisons);
    }

    /**
     * Overloaded method for default non-verbose use.
     */
    public static void sort(int[] arr) {
        sort(arr, false);
    }

    private static void sortHelper(int[] arr, int left, int right, boolean verbose) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        sortHelper(arr, left, mid, verbose);
        sortHelper(arr, mid + 1, right, verbose);
        merge(arr, left, mid, right, verbose);
    }

    private static void merge(int[] arr, int left, int mid, int right, boolean verbose) {
        merges++;

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];

        if (verbose) {
            System.out.printf("Merged [%d-%d]: ", left, right);
            printArray(arr, left, right);
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
