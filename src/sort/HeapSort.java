package sort;

public class HeapSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract elements
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i); // Move current root to end
            heapify(arr, i, 0); // Heapify reduced heap
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize root as largest
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
