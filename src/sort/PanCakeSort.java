package sort;

public class PanCakeSort {

    public static void sort(int[] arr) {
        for (int currSize = arr.length; currSize > 1; currSize--) {
            int maxIdx = findMaxIndex(arr, currSize);

            if (maxIdx != currSize - 1) {
                flip(arr, maxIdx);
                flip(arr, currSize - 1);
            }
        }
    }

    private static int findMaxIndex(int[] arr, int n) {
        int maxIdx = 0;
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[maxIdx]) maxIdx = i;
        return maxIdx;
    }

    private static void flip(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
