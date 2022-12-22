package sort;

import java.util.Random;

public class BogoSort {

    private static final Random rand = new Random();

    public static void sort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }

    private static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int r = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
    }
}
