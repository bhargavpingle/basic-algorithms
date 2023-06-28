package sort;

public class BitwiseSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length, 31); // 31 bits for signed int
    }

    private static void sort(int[] arr, int left, int right, int bit) {
        if (bit < 0 || right - left <= 1)
            return;

        int i = left, j = right - 1;
        while (i <= j) {
            while (i <= j && ((arr[i] >> bit) & 1) == 0)
                i++;
            while (i <= j && ((arr[j] >> bit) & 1) == 1)
                j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        sort(arr, left, i, bit - 1);
        sort(arr, i, right, bit - 1);
    }
}
