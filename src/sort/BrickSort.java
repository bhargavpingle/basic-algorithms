package sort;

public class BrickSort {
    public static void sort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int range = max - min + 1;
        int[] holes = new int[range];

        for (int num : arr) holes[num - min]++;
        int index = 0;

        for (int i = 0; i < range; i++) {
            while (holes[i]-- > 0) arr[index++] = i + min;
        }
    }
}
