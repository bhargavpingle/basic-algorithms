package sort;

public class RadixSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortByDigit(arr, exp);
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int num : arr)
            count[(num / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int idx = (arr[i] / exp) % 10;
            output[count[idx] - 1] = arr[i];
            count[idx]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            if (num > max) max = num;
        return max;
    }
}
