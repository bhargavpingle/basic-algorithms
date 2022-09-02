package sort;

public class BitonicSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        // Ensure length is power of 2
        if ((n & (n - 1)) != 0) {
            throw new IllegalArgumentException("Array size must be a power of 2 for Bitonic Sort.");
        }

        bitonicSort(arr, 0, n, true);
    }

    private static void bitonicSort(int[] arr, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;

            bitonicSort(arr, low, k, true);
            bitonicSort(arr, low + k, k, false);
            bitonicMerge(arr, low, count, ascending);
        }
    }

    private static void bitonicMerge(int[] arr, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;
            for (int i = low; i < low + k; i++) {
                if ((ascending && arr[i] > arr[i + k]) ||
                        (!ascending && arr[i] < arr[i + k])) {
                    swap(arr, i, i + k);
                }
            }
            bitonicMerge(arr, low, k, ascending);
            bitonicMerge(arr, low + k, k, ascending);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
}
