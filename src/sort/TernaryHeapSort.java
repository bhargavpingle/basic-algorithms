package sort;

public class TernaryHeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // Build max ternary heap
        for (int i = n / 3; i >= 0; i--) heapify(arr, n, i);

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;

        for (int k = 1; k <= 3; k++) {
            int child = 3 * i + k;
            if (child < n && arr[child] > arr[largest])
                largest = child;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}
