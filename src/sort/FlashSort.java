package sort;

public class FlashSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        int min = arr[0], maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > arr[maxIdx]) maxIdx = i;
        }

        if (arr[maxIdx] == min) return;

        int m = (int) (0.43 * n); // number of classes
        int[] l = new int[m];
        double c = (double)(m - 1) / (arr[maxIdx] - min);

        for (int i = 0; i < n; i++)
            l[(int)((arr[i] - min) * c)]++;

        for (int i = 1; i < m; i++)
            l[i] += l[i - 1];

        swap(arr, maxIdx, 0);

        int count = 0, i = 0;
        while (count < n - 1) {
            int k = (int)((arr[i] - min) * c);
            while (i >= l[k]) k = (int)((arr[i] - min) * c);

            if (arr[i] != arr[l[k] - 1]) {
                swap(arr, i, --l[k]);
                count++;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}
