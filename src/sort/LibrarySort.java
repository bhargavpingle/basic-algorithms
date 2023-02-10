package sort;

import java.util.ArrayList;
import java.util.Collections;

public class LibrarySort {

    public static void sort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            int pos = Collections.binarySearch(list, num);
            list.add(pos < 0 ? -pos - 1 : pos, num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}
