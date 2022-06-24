package sort;

import java.util.Arrays;

public class TimSort {
    static final int RUN = 32;

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        // Sort small runs using Insertion Sort
        for (int i = 0; i < n; i += RUN)
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));

        // Merge runs
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i], j = i - 1;
            while (j >= left && arr[j] > temp)
                arr[j + 1] = arr[j--];
            arr[j + 1] = temp;
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;

        while (i < left.length && j < right.length)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}
