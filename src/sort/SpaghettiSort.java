package sort;

import java.util.TreeMap;

public class SpaghettiSort {

    public static void sort(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        int index = 0;
        for (var entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr[index++] = entry.getKey();
            }
        }
    }
}
